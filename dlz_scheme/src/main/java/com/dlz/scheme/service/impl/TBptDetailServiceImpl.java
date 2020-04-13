package com.dlz.scheme.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dlz.scheme.mapper.TBptDetailMapper;
import com.dlz.scheme.domain.TBptDetail;
import com.dlz.scheme.service.ITBptDetailService;
import com.dlz.common.core.text.Convert;

/**
 * 方案明细Service业务层处理
 * 
 * @author lizhiyu
 * @date 2019-12-04
 */
@Service
public class TBptDetailServiceImpl implements ITBptDetailService 
{
    @Autowired
    private TBptDetailMapper tBptDetailMapper;

    /**
     * 查询方案明细
     * 
     * @param bpdid 方案明细ID
     * @return 方案明细
     */
    @Override
    public TBptDetail selectTBptDetailById(Long bpdid)
    {
        return tBptDetailMapper.selectTBptDetailById(bpdid);
    }
    

    /**
     * 查询方案明细列表
     * 
     * @param tBptDetail 方案明细
     * @return 方案明细
     */
    @Override
    public List<TBptDetail> selectTBptDetailList(TBptDetail tBptDetail)
    {
        return tBptDetailMapper.selectTBptDetailList(tBptDetail);
    }

    /**
     * 新增方案明细
     * 
     * @param tBptDetail 方案明细
     * @return 结果
     */
    @Override
    public int insertTBptDetail(TBptDetail tBptDetail)
    {
        return tBptDetailMapper.insertTBptDetail(tBptDetail);
    }

    /**
     * 修改方案明细
     * 
     * @param tBptDetail 方案明细
     * @return 结果
     */
    @Override
    public int updateTBptDetail(TBptDetail tBptDetail)
    {
        return tBptDetailMapper.updateTBptDetail(tBptDetail);
    }

    /**
     * 删除方案明细对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTBptDetailByIds(String ids)
    {
        return tBptDetailMapper.deleteTBptDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除方案明细信息
     * 
     * @param bpdid 方案明细ID
     * @return 结果
     */
    @Override
    public int deleteTBptDetailById(Long bpdid)
    {
        return tBptDetailMapper.deleteTBptDetailById(bpdid);
    }
    
    /**
     * 批量插入Key-Value
     * 
     * @param map
     * @return 结果
     */
    @Override
    public int batchInsert(Map<String,Object> map)
    {
    	List<Map> list=new ArrayList<Map>();
    	String bptid=map.get("bptid").toString();
    	for(String key :map.keySet())
    	{
    		if(!key.equals("bptid"))
    		{
    			Map<String,Object> newMap=new HashMap<String,Object>();
    			newMap.put("bptid", bptid);
    			newMap.put("detail", key);
    			newMap.put("detail_value", map.get(key));
    			list.add(newMap);
    			
    		}
    	}
    	return tBptDetailMapper.batchInsert(list);
    }
    
    /**
     * 批量更新Key-Value
     * 
     * @param map
     * @return 结果
     */
    @Override
    public int batchUpdate(Map<String,Object> map)
    {
    	List<Map> list=new ArrayList<Map>();
    	String bptid=map.get("bptid").toString();
    	for(String key :map.keySet())
    	{
    		if(!key.equals("bptid"))
    		{
    			Map<String,Object> newMap=new HashMap<String,Object>();
    			newMap.put("bptid", bptid);
    			newMap.put("detail", key);
    			newMap.put("detail_value", map.get(key));
    			list.add(newMap);
    		}
    	}
    	return tBptDetailMapper.batchUpdate(list);
    }
}
