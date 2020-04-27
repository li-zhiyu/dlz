package com.dlz.scheme.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dlz.scheme.mapper.TProjectCostinfoMapper;
import com.dlz.scheme.domain.TProjectCostinfo;
import com.dlz.scheme.service.ITProjectCostinfoService;
import com.dlz.common.core.text.Convert;

/**
 * 方案成本Service业务层处理
 * 
 * @author lizhiyu
 * @date 2020-04-27
 */
@Service
public class TProjectCostinfoServiceImpl implements ITProjectCostinfoService 
{
    @Autowired
    private TProjectCostinfoMapper tProjectCostinfoMapper;

    /**
     * 查询方案成本
     * 
     * @param pciid 方案成本ID
     * @return 方案成本
     */
    @Override
    public TProjectCostinfo selectTProjectCostinfoById(Long pciid)
    {
        return tProjectCostinfoMapper.selectTProjectCostinfoById(pciid);
    }

    /**
     * 查询方案成本列表
     * 
     * @param tProjectCostinfo 方案成本
     * @return 方案成本
     */
    @Override
    public List<TProjectCostinfo> selectTProjectCostinfoList(TProjectCostinfo tProjectCostinfo)
    {
        return tProjectCostinfoMapper.selectTProjectCostinfoList(tProjectCostinfo);
    }

    /**
     * 新增方案成本
     * 
     * @param tProjectCostinfo 方案成本
     * @return 结果
     */
    @Override
    public int insertTProjectCostinfo(TProjectCostinfo tProjectCostinfo)
    {
        return tProjectCostinfoMapper.insertTProjectCostinfo(tProjectCostinfo);
    }

    /**
     * 修改方案成本
     * 
     * @param tProjectCostinfo 方案成本
     * @return 结果
     */
    @Override
    public int updateTProjectCostinfo(TProjectCostinfo tProjectCostinfo)
    {
        return tProjectCostinfoMapper.updateTProjectCostinfo(tProjectCostinfo);
    }

    /**
     * 删除方案成本对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTProjectCostinfoByIds(String ids)
    {
        return tProjectCostinfoMapper.deleteTProjectCostinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除方案成本信息
     * 
     * @param pciid 方案成本ID
     * @return 结果
     */
    @Override
    public int deleteTProjectCostinfoById(Long pciid)
    {
        return tProjectCostinfoMapper.deleteTProjectCostinfoById(pciid);
    }
}
