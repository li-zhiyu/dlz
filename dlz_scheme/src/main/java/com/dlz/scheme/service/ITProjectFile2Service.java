package com.dlz.scheme.service;

import com.dlz.common.core.domain.AjaxResult;
import com.dlz.scheme.domain.TProjectFile2;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 项目文件管理Service接口
 * 
 * @author lizhiyu
 * @date 2020-03-27
 */
public interface ITProjectFile2Service
{
    /**
     * 查询项目文件管理
     *
     * @param id 项目文件管理ID
     * @return 项目文件管理
     */
    public TProjectFile2 selectTProjectFileById(Long id);

    /**
     * 查询项目文件管理列表
     *
     * @param tProjectFile2 项目文件管理
     * @return 项目文件管理集合
     */
    public List<TProjectFile2> selectTProjectFileList(TProjectFile2 tProjectFile2);

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
     * @param tProjectFile2 项目文件管理
     * @return 结果
     */
    public int updateTProjectFile(TProjectFile2 tProjectFile2);

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

}
