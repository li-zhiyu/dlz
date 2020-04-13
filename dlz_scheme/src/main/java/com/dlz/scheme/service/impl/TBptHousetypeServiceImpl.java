package com.dlz.scheme.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dlz.scheme.mapper.TBptHousetypeMapper;
import com.dlz.scheme.domain.TBptHousetype;
import com.dlz.scheme.service.ITBptHousetypeService;
import com.dlz.common.core.text.Convert;

/**
 * 户型Service业务层处理
 * 
 * @author lizhiyu
 * @date 2019-12-16
 */
@Service
public class TBptHousetypeServiceImpl implements ITBptHousetypeService 
{
    @Autowired
    private TBptHousetypeMapper tBptHousetypeMapper;

    /**
     * 查询户型
     * 
     * @param htid 户型ID
     * @return 户型
     */
    @Override
    public TBptHousetype selectTBptHousetypeById(Long htid)
    {
        return tBptHousetypeMapper.selectTBptHousetypeById(htid);
    }

    /**
     * 查询户型列表
     * 
     * @param tBptHousetype 户型
     * @return 户型
     */
    @Override
    public List<TBptHousetype> selectTBptHousetypeList(TBptHousetype tBptHousetype)
    {
        return tBptHousetypeMapper.selectTBptHousetypeList(tBptHousetype);
    }

    /**
     * 新增户型
     * 
     * @param tBptHousetype 户型
     * @return 结果
     */
    @Override
    public int insertTBptHousetype(TBptHousetype tBptHousetype)
    {
        return tBptHousetypeMapper.insertTBptHousetype(tBptHousetype);
    }

    /**
     * 修改户型
     * 
     * @param tBptHousetype 户型
     * @return 结果
     */
    @Override
    public int updateTBptHousetype(TBptHousetype tBptHousetype)
    {
        return tBptHousetypeMapper.updateTBptHousetype(tBptHousetype);
    }

    /**
     * 删除户型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTBptHousetypeByIds(String ids)
    {
        return tBptHousetypeMapper.deleteTBptHousetypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除户型信息
     * 
     * @param htid 户型ID
     * @return 结果
     */
    @Override
    public int deleteTBptHousetypeById(Long htid)
    {
        return tBptHousetypeMapper.deleteTBptHousetypeById(htid);
    }
}
