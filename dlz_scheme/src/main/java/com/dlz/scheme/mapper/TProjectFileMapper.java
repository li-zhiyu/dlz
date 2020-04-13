package com.dlz.scheme.mapper;

import com.dlz.scheme.domain.TProjectFile;
import java.util.List;

/**
 * 项目文件管理Mapper接口
 * 
 * @author lizhiyu
 * @date 2020-03-27
 */
public interface TProjectFileMapper 
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
     * @param tProjectFile 项目文件管理
     * @return 结果
     */
    public int insertTProjectFile(TProjectFile tProjectFile);

    /**
     * 修改项目文件管理
     * 
     * @param tProjectFile 项目文件管理
     * @return 结果
     */
    public int updateTProjectFile(TProjectFile tProjectFile);

    /**
     * 删除项目文件管理
     * 
     * @param id 项目文件管理ID
     * @return 结果
     */
    public int deleteTProjectFileById(Long id);

    /**
     * 批量删除项目文件管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTProjectFileByIds(String[] ids);
}
