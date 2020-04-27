package com.dlz.scheme.mapper;

import com.dlz.scheme.domain.TProjectCostinfo;
import java.util.List;

/**
 * 方案成本Mapper接口
 * 
 * @author lizhiyu
 * @date 2020-04-27
 */
public interface TProjectCostinfoMapper 
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
     * 删除方案成本
     * 
     * @param pciid 方案成本ID
     * @return 结果
     */
    public int deleteTProjectCostinfoById(Long pciid);

    /**
     * 批量删除方案成本
     * 
     * @param pciids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTProjectCostinfoByIds(String[] pciids);
}
