package com.dlz.scheme.mapper;

import com.dlz.scheme.domain.TBptMain;
import java.util.List;

/**
 * 方案管理Mapper接口
 * 
 * @author lizhiyu
 * @date 2019-12-04
 */
public interface TBptMainMapper 
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
     * 修改方案管理
     * 
     * @param tBptMain 方案管理
     * @return 结果
     */
    public int updateTBptMain(TBptMain tBptMain);

    /**
     * 删除方案管理
     * 
     * @param bptid 方案管理ID
     * @return 结果
     */
    public int deleteTBptMainById(Long bptid);

    /**
     * 批量删除方案管理
     * 
     * @param bptids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTBptMainByIds(String[] bptids);
}
