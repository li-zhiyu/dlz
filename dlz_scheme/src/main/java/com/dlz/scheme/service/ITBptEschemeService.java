package com.dlz.scheme.service;

import com.dlz.scheme.domain.TBptEscheme;

import java.util.List;

/**
 * 装配方案Service接口
 * 
 * @author lizhiyu
 * @date 2019-12-10
 */
public interface ITBptEschemeService 
{
    /**
     * 查询装配方案
     * 
     * @param bpeid 装配方案ID
     * @return 装配方案
     */
    public TBptEscheme selectTBptEschemeById(Long bpeid);

    /**
     * 查询装配方案列表
     * 
     * @param tBptEscheme 装配方案
     * @return 装配方案集合
     */
    public List<TBptEscheme> selectTBptEschemeList(TBptEscheme tBptEscheme);

    /**
     * 新增装配方案
     * 
     * @param tBptEscheme 装配方案
     * @return 结果
     */
    public int insertTBptEscheme(TBptEscheme tBptEscheme);

    /**
     * 修改装配方案
     * 
     * @param tBptEscheme 装配方案
     * @return 结果
     */
    public int updateTBptEscheme(TBptEscheme tBptEscheme);

    /**
     * 批量删除装配方案
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTBptEschemeByIds(String ids);

    /**
     * 删除装配方案信息
     * 
     * @param bpeid 装配方案ID
     * @return 结果
     */
    public int deleteTBptEschemeById(Long bpeid);
}
