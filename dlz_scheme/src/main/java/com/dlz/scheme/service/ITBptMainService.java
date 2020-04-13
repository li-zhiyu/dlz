package com.dlz.scheme.service;

import com.dlz.common.core.domain.AjaxResult;
import com.dlz.scheme.domain.TBptMain;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 方案管理Service接口
 * 
 * @author lizhiyu
 * @date 2019-12-04
 */
public interface ITBptMainService 
{
    /**
     * 查询方案管理
     * 
     * @param bptid 方案管理ID
     * @return 方案管理
     */
    public TBptMain selectTBptMainById(Long bptid);

    /**
     * 查询方案管理列表
     * 
     * @param tBptMain 方案管理
     * @return 方案管理集合
     */
    public List<TBptMain> selectTBptMainList(TBptMain tBptMain);

    /**
     * 新增方案管理
     * 
     * @param tBptMain 方案管理
     * @return 结果
     */
    public int insertTBptMain(TBptMain tBptMain);
    
    /**
     * 新增方案
     * 
     * @param tBptMain 方案管理
     * @return 结果
     */
    public AjaxResult insertTBptMainAll(MultipartFile file , String formData);

    /**
     * 修改方案管理
     * 
     * @param tBptMain 方案管理
     * @return 结果
     */
    public int updateTBptMain(TBptMain tBptMain);

    /**
     * 批量删除方案管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTBptMainByIds(String ids);

    /**
     * 删除方案管理信息
     * 
     * @param bptid 方案管理ID
     * @return 结果
     */
    public int deleteTBptMainById(Long bptid);
}
