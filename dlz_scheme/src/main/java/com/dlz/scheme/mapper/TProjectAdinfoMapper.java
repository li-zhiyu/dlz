package com.dlz.scheme.mapper;

import com.dlz.scheme.domain.TProjectAdinfo;
import java.util.List;

/**
 * 方案对比数据Mapper接口
 * 
 * @author lizhiyu
 * @date 2020-04-03
 */
public interface TProjectAdinfoMapper 
{
    /**
     * 查询方案对比数据
     * 
     * @param padid 方案对比数据ID
     * @return 方案对比数据
     */
    public TProjectAdinfo selectTProjectAdinfoById(Long padid);

    /**
     * 查询方案对比数据列表
     * 
     * @param tProjectAdinfo 方案对比数据
     * @return 方案对比数据集合
     */
    public List<TProjectAdinfo> selectTProjectAdinfoList(TProjectAdinfo tProjectAdinfo);

    /**
     * 新增方案对比数据
     * 
     * @param tProjectAdinfo 方案对比数据
     * @return 结果
     */
    public int insertTProjectAdinfo(TProjectAdinfo tProjectAdinfo);

    /**
     * 修改方案对比数据
     * 
     * @param tProjectAdinfo 方案对比数据
     * @return 结果
     */
    public int updateTProjectAdinfo(TProjectAdinfo tProjectAdinfo);

    /**
     * 删除方案对比数据
     * 
     * @param padid 方案对比数据ID
     * @return 结果
     */
    public int deleteTProjectAdinfoById(Long padid);

    /**
     * 批量删除方案对比数据
     * 
     * @param padids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTProjectAdinfoByIds(String[] padids);

    /**
     * 批量插入方案对比数据
     *
     * @param tProjectAdinfos 要插入的数据
     * @return 结果
     */
    public int batchInsertTProjectAdinfo(List<TProjectAdinfo> tProjectAdinfos);
}
