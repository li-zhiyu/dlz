package com.dlz.scheme.service;

import com.dlz.scheme.domain.TProjectCostinfo;
import java.util.List;

/**
 * 方案成本Service接口
 * 
 * @author lizhiyu
 * @date 2020-04-27
 */
public interface ITProjectCostinfoService 
{
    /**
     * 查询方案成本
     * 
     * @param pciid 方案成本ID
     * @return 方案成本
     */
    public TProjectCostinfo selectTProjectCostinfoById(Long pciid);

    /**
     * 查询方案成本列表
     * 
     * @param tProjectCostinfo 方案成本
     * @return 方案成本集合
     */
    public List<TProjectCostinfo> selectTProjectCostinfoList(TProjectCostinfo tProjectCostinfo);

    /**
     * 新增方案成本
     * 
     * @param tProjectCostinfo 方案成本
     * @return 结果
     */
    public int insertTProjectCostinfo(TProjectCostinfo tProjectCostinfo);

    /**
     * 修改方案成本
     * 
     * @param tProjectCostinfo 方案成本
     * @return 结果
     */
    public int updateTProjectCostinfo(TProjectCostinfo tProjectCostinfo);

    /**
     * 批量删除方案成本
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTProjectCostinfoByIds(String ids);

    /**
     * 删除方案成本信息
     * 
     * @param pciid 方案成本ID
     * @return 结果
     */
    public int deleteTProjectCostinfoById(Long pciid);
}
