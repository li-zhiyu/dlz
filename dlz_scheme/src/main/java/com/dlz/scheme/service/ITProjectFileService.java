package com.dlz.scheme.service;

import com.bimface.exception.BimfaceException;
import com.dlz.common.core.domain.AjaxResult;
import com.dlz.scheme.domain.TProjectFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 项目文件管理Service接口
 * 
 * @author lizhiyu
 * @date 2020-03-27
 */
public interface ITProjectFileService 
{
    /**
     * 查询项目文件管理
     * 
     * @param id 项目文件管理ID
     * @return 项目文件管理
     */
    public TProjectFile selectTProjectFileById(Long id);

    /**
     * 查询项目文件管理列表
     * 
     * @param tProjectFile 项目文件管理
     * @return 项目文件管理集合
     */
    public List<TProjectFile> selectTProjectFileList(TProjectFile tProjectFile);

    /**
     * 新增项目文件管理
     * 
     * @param file 项目文件管理
     * @return 结果
     */
    public AjaxResult insertTProjectFile(MultipartFile file, String formData);

    /**
     * 修改项目文件管理
     * 
     * @param tProjectFile 项目文件管理
     * @return 结果
     */
    public int updateTProjectFile(TProjectFile tProjectFile);

    /**
     * 批量删除项目文件管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTProjectFileByIds(String ids);

    /**
     * 删除项目文件管理信息
     * 
     * @param id 项目文件管理ID
     * @return 结果
     */
    public int deleteTProjectFileById(Long id);

    public int updateTProjectFileAfterConvert(Long id,Long fileId) throws BimfaceException;
}
