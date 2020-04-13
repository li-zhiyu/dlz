package com.dlz.scheme.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSONObject;
import com.bimface.api.bean.response.FileTranslateBean;
import com.bimface.exception.BimfaceException;
import com.bimface.file.bean.FileBean;
import com.bimface.sdk.BimfaceClient;
import com.dlz.common.config.Global;
import com.dlz.common.core.domain.AjaxResult;
import com.dlz.common.enums.FileStatus;
import com.dlz.common.utils.DateUtils;
import com.dlz.common.utils.URLStringToJsonUtil;
import com.dlz.common.utils.file.FileUploadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dlz.scheme.mapper.TProjectFileMapper;
import com.dlz.scheme.domain.TProjectFile;
import com.dlz.scheme.service.ITProjectFileService;
import com.dlz.common.core.text.Convert;
import org.springframework.web.multipart.MultipartFile;

/**
 * 项目文件管理Service业务层处理
 * 
 * @author lizhiyu
 * @date 2020-03-27
 */
@Service
public class TProjectFileServiceImpl implements ITProjectFileService 
{
    @Autowired
    private TProjectFileMapper tProjectFileMapper;

    @Autowired
    private BimfaceClient bimfaceClient;

    private static final Logger logger = LoggerFactory.getLogger(TProjectFileServiceImpl.class);

    /**
     * 查询项目文件管理
     * 
     * @param id 项目文件管理ID
     * @return 项目文件管理
     */
    @Override
    public TProjectFile selectTProjectFileById(Long id)
    {
        return tProjectFileMapper.selectTProjectFileById(id);
    }

    /**
     * 查询项目文件管理列表
     * 
     * @param tProjectFile 项目文件管理
     * @return 项目文件管理
     */
    @Override
    public List<TProjectFile> selectTProjectFileList(TProjectFile tProjectFile)
    {
        return tProjectFileMapper.selectTProjectFileList(tProjectFile);
    }

    /**
     * 新增项目文件管理
     * 
     * @param file 项目文件管理
     * @return 结果
     */
    @Override
    public AjaxResult insertTProjectFile(MultipartFile file, String formData)
    {
        try {
            if (!file.isEmpty()){
                JSONObject formParam= URLStringToJsonUtil.convertJson(formData);

                String fileName=file.getOriginalFilename();
                FileBean fileBean = bimfaceClient.upload(fileName, file.getSize(), file.getInputStream());

                if (fileBean.getStatus().equals("success")){
                    TProjectFile tBptProjectFile = new TProjectFile();
                    tBptProjectFile.setPjtid(formParam.getString("pjtid"));
                    tBptProjectFile.setFileName(fileName);
                    tBptProjectFile.setFileFormat(fileBean.getSuffix());
                    tBptProjectFile.setFileType(formParam.getString("fileType"));
                    tBptProjectFile.setFileId(String.valueOf(fileBean.getFileId()));
                    tBptProjectFile.setCreateTime(DateUtils.getNowDate());
                    tBptProjectFile.setStatus(FileStatus.UPLOAD_SUCCESS.getCode());

                    int i = tProjectFileMapper.insertTProjectFile(tBptProjectFile);
                    if (i == 0) return AjaxResult.error();
                    return AjaxResult.success();

                }
            }
            return AjaxResult.error();
        } catch (IOException | BimfaceException e) {
            e.printStackTrace();
            logger.error("文件上传Bimface云失败");
            return AjaxResult.error();
        }
    }

    /**
     * 修改项目文件管理
     * 
     * @param tProjectFile 项目文件管理
     * @return 结果
     */
    @Override
    public int updateTProjectFile(TProjectFile tProjectFile)
    {
        return tProjectFileMapper.updateTProjectFile(tProjectFile);
    }

    /**
     * 删除项目文件管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTProjectFileByIds(String ids)
    {
        return tProjectFileMapper.deleteTProjectFileByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除项目文件管理信息
     * 
     * @param id 项目文件管理ID
     * @return 结果
     */
    @Override
    public int deleteTProjectFileById(Long id)
    {
        return tProjectFileMapper.deleteTProjectFileById(id);
    }

    @Override
    public int updateTProjectFileAfterConvert(Long id,Long fileId)  {

        new Thread(()->{
            try {
                FileTranslateBean fileTranslateBean = bimfaceClient.translate(fileId);
                while(true){
                    TimeUnit.SECONDS.sleep(60);
                    FileTranslateBean translate = bimfaceClient.getTranslate(fileId);
                    String status = translate.getStatus();
                    if (status.equals("success")){
                        TProjectFile tProjectFile = new TProjectFile();
                        tProjectFile.setId(id);
                        tProjectFile.setStatus(FileStatus.CONVERT_SUCCESS.getCode());
                        tProjectFileMapper.updateTProjectFile(tProjectFile);
                        return;
                    }
                    if (status.equals("failed")){
                        TProjectFile tProjectFile = new TProjectFile();
                        tProjectFile.setId(id);
                        tProjectFile.setStatus(FileStatus.CONVERT_FAIL.getCode());
                        tProjectFileMapper.updateTProjectFile(tProjectFile);
                        return;
                    }
                }
            } catch (BimfaceException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        TProjectFile tProjectFile = new TProjectFile();
        tProjectFile.setId(id);
        tProjectFile.setStatus(FileStatus.CONVERT_PROCESSING.getCode());
        tProjectFileMapper.updateTProjectFile(tProjectFile);
        return 1;
    }
}
