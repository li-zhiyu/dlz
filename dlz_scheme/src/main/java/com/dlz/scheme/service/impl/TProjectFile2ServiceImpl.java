package com.dlz.scheme.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bimface.api.bean.response.FileTranslateBean;
import com.bimface.exception.BimfaceException;
import com.bimface.file.bean.FileBean;
import com.bimface.sdk.BimfaceClient;
import com.dlz.common.config.Global;
import com.dlz.common.core.domain.AjaxResult;
import com.dlz.common.core.text.Convert;
import com.dlz.common.enums.FileStatus;
import com.dlz.common.utils.DateUtils;
import com.dlz.common.utils.URLStringToJsonUtil;
import com.dlz.common.utils.file.FileUploadUtils;
import com.dlz.scheme.domain.TBptComponent;
import com.dlz.scheme.domain.TProjectFile;
import com.dlz.scheme.domain.TProjectFile2;
import com.dlz.scheme.mapper.TProjectFile2Mapper;
import com.dlz.scheme.service.ITProjectFile2Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 项目文件管理Service业务层处理
 * 
 * @author lizhiyu
 * @date 2020-03-27
 */
@Service
public class TProjectFile2ServiceImpl implements ITProjectFile2Service
{
    @Autowired
    private TProjectFile2Mapper tProjectFile2Mapper;


    private static final Logger logger = LoggerFactory.getLogger(TProjectFile2ServiceImpl.class);

    /**
     * 查询项目文件管理
     * 
     * @param id 项目文件管理ID
     * @return 项目文件管理
     */
    @Override
    public TProjectFile2 selectTProjectFileById(Long id)
    {
        return tProjectFile2Mapper.selectTProjectFileById(id);
    }

    /**
     * 查询项目文件管理列表
     * 
     * @param tProjectFile2 项目文件管理
     * @return 项目文件管理
     */
    @Override
    public List<TProjectFile2> selectTProjectFileList(TProjectFile2 tProjectFile2)
    {
        return tProjectFile2Mapper.selectTProjectFileList(tProjectFile2);
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
                String path = FileUploadUtils.upload(Global.getProjectFile2Path(), file);
                String fileName=file.getOriginalFilename();
                String fileFormat=fileName.substring(fileName.lastIndexOf(".")+1);
                JSONObject formParam= URLStringToJsonUtil.convertJson(formData);
                TProjectFile2 tProjectFile2 = JSONObject.toJavaObject(formParam, TProjectFile2.class);
                tProjectFile2.setFileName(fileName);
                tProjectFile2.setFileFormat(fileFormat);
                tProjectFile2.setPath(path);
                tProjectFile2.setCreateTime(DateUtils.getNowDate());
                int i = tProjectFile2Mapper.insertTProjectFile(tProjectFile2);
                if (i == 0) return AjaxResult.error();
                return AjaxResult.success();
            }
            return AjaxResult.error();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("文件上传失败");
            return AjaxResult.error();
        }
    }

    /**
     * 修改项目文件管理
     * 
     * @param tProjectFile2 项目文件管理
     * @return 结果
     */
    @Override
    public int updateTProjectFile(TProjectFile2 tProjectFile2)
    {
        return tProjectFile2Mapper.updateTProjectFile(tProjectFile2);
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
        return tProjectFile2Mapper.deleteTProjectFileByIds(Convert.toStrArray(ids));
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
        return tProjectFile2Mapper.deleteTProjectFileById(id);
    }

}
