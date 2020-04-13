package com.dlz.scheme.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dlz.scheme.mapper.TBptParamMapper;
import com.dlz.scheme.domain.TBptParam;
import com.dlz.scheme.service.ITBptParamService;
import com.dlz.common.core.text.Convert;

/**
 * 方案参数Service业务层处理
 * 
 * @author lizhiyu
 * @date 2019-12-06
 */
@Service
public class TBptParamServiceImpl implements ITBptParamService 
{
    @Autowired
    private TBptParamMapper tBptParamMapper;

    /**
     * 查询方案参数
     * 
     * @param bppid 方案参数ID
     * @return 方案参数
     */
    @Override
    public TBptParam selectTBptParamById(Long bppid)
    {
        return tBptParamMapper.selectTBptParamById(bppid);
    }

    /**
     * 查询方案参数列表
     * 
     * @param tBptParam 方案参数
     * @return 方案参数
     */
    @Override
    public List<TBptParam> selectTBptParamList(TBptParam tBptParam)
    {
        return tBptParamMapper.selectTBptParamList(tBptParam);
    }

    /**
     * 新增方案参数
     * 
     * @param tBptParam 方案参数
     * @return 结果
     */
    @Override
    public int insertTBptParam(TBptParam tBptParam)
    {
        return tBptParamMapper.insertTBptParam(tBptParam);
    }

    /**
     * 修改方案参数
     * 
     * @param tBptParam 方案参数
     * @return 结果
     */
    @Override
    public int updateTBptParam(TBptParam tBptParam)
    {
        return tBptParamMapper.updateTBptParam(tBptParam);
    }

    /**
     * 删除方案参数对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTBptParamByIds(String ids)
    {
        return tBptParamMapper.deleteTBptParamByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除方案参数信息
     * 
     * @param bppid 方案参数ID
     * @return 结果
     */
    @Override
    public int deleteTBptParamById(Long bppid)
    {
        return tBptParamMapper.deleteTBptParamById(bppid);
    }
    
    /**
     * 批量更新K-V
     * 
     * @param bppid 方案参数ID
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
    			newMap.put("param", key);
    			newMap.put("param_value", map.get(key));
    			list.add(newMap);
    		}
    	}
    	return tBptParamMapper.batchUpdate(list);
    }
    
}
