package com.dlz.scheme.service.impl;

import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.dlz.common.config.Global;
import com.dlz.common.core.domain.AjaxResult;
import com.dlz.common.utils.DateUtils;
import com.dlz.common.utils.URLStringToJsonUtil;
import com.dlz.common.utils.file.FileUploadUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dlz.scheme.mapper.TBptMainFileMapper;
import com.dlz.scheme.domain.TBptMainFile;
import com.dlz.scheme.service.ITBptMainFileService;
import com.dlz.common.core.text.Convert;
import org.springframework.web.multipart.MultipartFile;

/**
 * 方案文件管理Service业务层处理
 * 
 * @author lizhiyu
 * @date 2020-02-26
 */
@Service
public class TBptMainFileServiceImpl implements ITBptMainFileService 
{
    @Autowired
    private TBptMainFileMapper tBptMainFileMapper;

    /**
     * 查询方案文件管理
     * 
     * @param id 方案文件管理ID
     * @return 方案文件管理
     */
    @Override
    public TBptMainFile selectTBptMainFileById(Long id)
    {
        return tBptMainFileMapper.selectTBptMainFileById(id);
    }

    /**
     * 查询方案文件管理列表
     * 
     * @param tBptMainFile 方案文件管理
     * @return 方案文件管理
     */
    @Override
    public List<TBptMainFile> selectTBptMainFileList(TBptMainFile tBptMainFile)
    {
        return tBptMainFileMapper.selectTBptMainFileList(tBptMainFile);
    }

    /**
     * 新增方案文件管理
     * 
     * @param  file, formData 方案文件管理
     * @return 结果
     */
    @Override
    public AjaxResult insertTBptMainFile(MultipartFile file, String formData)
    {
        try {
            if (!file.isEmpty()){
                String path = FileUploadUtils.upload(Global.getProjectFilePath(), file);
                String fileName=file.getOriginalFilename();
                JSONObject formParam= URLStringToJsonUtil.convertJson(formData);

                TBptMainFile tBptMainFile = new TBptMainFile();
                tBptMainFile.setBptid(formParam.getString("pjtid"));
                tBptMainFile.setFileName(fileName);
                tBptMainFile.setFileType(formParam.getString("fileType"));
                tBptMainFile.setPath(path);
                tBptMainFile.setCreateTime(DateUtils.getNowDate());
                int i = tBptMainFileMapper.insertTBptMainFile(tBptMainFile);
                if (i == 0) return AjaxResult.error();
                return AjaxResult.success();

            }
            return AjaxResult.error();
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.error();
        }

    }

    /**
     * 修改方案文件管理
     * 
     * @param tBptMainFile 方案文件管理
     * @return 结果
     */
    @Override
    public int updateTBptMainFile(TBptMainFile tBptMainFile)
    {
        return tBptMainFileMapper.updateTBptMainFile(tBptMainFile);
    }

    /**
     * 删除方案文件管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTBptMainFileByIds(String ids)
    {
        return tBptMainFileMapper.deleteTBptMainFileByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除方案文件管理信息
     * 
     * @param id 方案文件管理ID
     * @return 结果
     */
    @Override
    public int deleteTBptMainFileById(Long id)
    {
        return tBptMainFileMapper.deleteTBptMainFileById(id);
    }
}
