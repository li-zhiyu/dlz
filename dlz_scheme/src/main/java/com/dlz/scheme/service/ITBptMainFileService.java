package com.dlz.scheme.service;

import com.dlz.common.core.domain.AjaxResult;
import com.dlz.scheme.domain.TBptMainFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 方案文件管理Service接口
 * 
 * @author lizhiyu
 * @date 2020-02-26
 */
public interface ITBptMainFileService 
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
    public AjaxResult insertTBptMainFile(MultipartFile file, String formData);

    /**
     * 修改方案文件管理
     * 
     * @param tBptMainFile 方案文件管理
     * @return 结果
     */
    public int updateTBptMainFile(TBptMainFile tBptMainFile);

    /**
     * 批量删除方案文件管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTBptMainFileByIds(String ids);

    /**
     * 删除方案文件管理信息
     * 
     * @param id 方案文件管理ID
     * @return 结果
     */
    public int deleteTBptMainFileById(Long id);
}
