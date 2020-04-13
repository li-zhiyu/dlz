package com.dlz.scheme.mapper;

import com.dlz.scheme.domain.TBptMainFile;
import java.util.List;

/**
 * 方案文件管理Mapper接口
 * 
 * @author lizhiyu
 * @date 2020-02-26
 */
public interface TBptMainFileMapper 
{
    /**
     * 查询方案文件管理
     * 
     * @param id 方案文件管理ID
     * @return 方案文件管理
     */
    public TBptMainFile selectTBptMainFileById(Long id);

    /**
     * 查询方案文件管理列表
     * 
     * @param tBptMainFile 方案文件管理
     * @return 方案文件管理集合
     */
    public List<TBptMainFile> selectTBptMainFileList(TBptMainFile tBptMainFile);

    /**
     * 新增方案文件管理
     * 
     * @param tBptMainFile 方案文件管理
     * @return 结果
     */
    public int insertTBptMainFile(TBptMainFile tBptMainFile);

    /**
     * 修改方案文件管理
     * 
     * @param tBptMainFile 方案文件管理
     * @return 结果
     */
    public int updateTBptMainFile(TBptMainFile tBptMainFile);

    /**
     * 删除方案文件管理
     * 
     * @param id 方案文件管理ID
     * @return 结果
     */
    public int deleteTBptMainFileById(Long id);

    /**
     * 批量删除方案文件管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTBptMainFileByIds(String[] ids);
}
