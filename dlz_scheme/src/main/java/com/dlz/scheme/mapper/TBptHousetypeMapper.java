package com.dlz.scheme.mapper;

import com.dlz.scheme.domain.TBptHousetype;
import java.util.List;

/**
 * 户型Mapper接口
 * 
 * @author lizhiyu
 * @date 2019-12-16
 */
public interface TBptHousetypeMapper 
{
    /**
     * 查询户型
     * 
     * @param htid 户型ID
     * @return 户型
     */
    public TBptHousetype selectTBptHousetypeById(Long htid);

    /**
     * 查询户型列表
     * 
     * @param tBptHousetype 户型
     * @return 户型集合
     */
    public List<TBptHousetype> selectTBptHousetypeList(TBptHousetype tBptHousetype);

    /**
     * 新增户型
     * 
     * @param tBptHousetype 户型
     * @return 结果
     */
    public int insertTBptHousetype(TBptHousetype tBptHousetype);

    /**
     * 修改户型
     * 
     * @param tBptHousetype 户型
     * @return 结果
     */
    public int updateTBptHousetype(TBptHousetype tBptHousetype);

    /**
     * 删除户型
     * 
     * @param htid 户型ID
     * @return 结果
     */
    public int deleteTBptHousetypeById(Long htid);

    /**
     * 批量删除户型
     * 
     * @param htids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTBptHousetypeByIds(String[] htids);
}
