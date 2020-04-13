package com.dlz.scheme.service;

import com.dlz.scheme.domain.TBptDetail;
import java.util.List;
import java.util.Map;

/**
 * 方案明细Service接口
 * 
 * @author lizhiyu
 * @date 2019-12-04
 */
public interface ITBptDetailService 
{
    /**
     * 查询方案明细
     * 
     * @param bpdid 方案明细ID
     * @return 方案明细
     */
    public TBptDetail selectTBptDetailById(Long bpdid);
    

    /**
     * 查询方案明细列表
     * 
     * @param tBptDetail 方案明细
     * @return 方案明细集合
     */
    public List<TBptDetail> selectTBptDetailList(TBptDetail tBptDetail);

    /**
     * 新增方案明细
     * 
     * @param tBptDetail 方案明细
     * @return 结果
     */
    public int insertTBptDetail(TBptDetail tBptDetail);

    /**
     * 修改方案明细
     * 
     * @param tBptDetail 方案明细
     * @return 结果
     */
    public int updateTBptDetail(TBptDetail tBptDetail);

    /**
     * 批量删除方案明细
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTBptDetailByIds(String ids);

    /**
     * 删除方案明细信息
     * 
     * @param bpdid 方案明细ID
     * @return 结果
     */
    public int deleteTBptDetailById(Long bpdid);
    
    /**
     * 批量插入key-value
     * 
     * @param map
     * @return 结果
     */
    public int batchInsert(Map<String,Object> map);
    
    /**
     * 批量更新key-value
     * 
     * @param map
     * @return 结果
     */
    public int batchUpdate(Map<String,Object> map);
}
