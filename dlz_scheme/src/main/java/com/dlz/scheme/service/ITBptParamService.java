package com.dlz.scheme.service;

import com.dlz.scheme.domain.TBptParam;
import java.util.List;
import java.util.Map;

/**
 * 方案参数Service接口
 * 
 * @author lizhiyu
 * @date 2019-12-06
 */
public interface ITBptParamService 
{
    /**
     * 查询方案参数
     * 
     * @param bppid 方案参数ID
     * @return 方案参数
     */
    public TBptParam selectTBptParamById(Long bppid);

    /**
     * 查询方案参数列表
     * 
     * @param tBptParam 方案参数
     * @return 方案参数集合
     */
    public List<TBptParam> selectTBptParamList(TBptParam tBptParam);

    /**
     * 新增方案参数
     * 
     * @param tBptParam 方案参数
     * @return 结果
     */
    public int insertTBptParam(TBptParam tBptParam);

    /**
     * 修改方案参数
     * 
     * @param tBptParam 方案参数
     * @return 结果
     */
    public int updateTBptParam(TBptParam tBptParam);

    /**
     * 批量删除方案参数
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTBptParamByIds(String ids);

    /**
     * 删除方案参数信息
     * 
     * @param bppid 方案参数ID
     * @return 结果
     */
    public int deleteTBptParamById(Long bppid);
    
    /**
     * 批量更新K-V
     * 
     * @param 
     * @return 结果
     */
    public int batchUpdate(Map<String,Object> map);
}
