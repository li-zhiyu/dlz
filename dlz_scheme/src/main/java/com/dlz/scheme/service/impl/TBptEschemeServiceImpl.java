package com.dlz.scheme.service.impl;

import java.util.List;
import com.dlz.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dlz.scheme.mapper.TBptEschemeMapper;
import com.dlz.scheme.domain.TBptEscheme;
import com.dlz.scheme.service.ITBptEschemeService;
import com.dlz.common.core.text.Convert;

/**
 * 装配方案Service业务层处理
 * 
 * @author lizhiyu
 * @date 2019-12-10
 */
@Service
public class TBptEschemeServiceImpl implements ITBptEschemeService 
{
    @Autowired
    private TBptEschemeMapper tBptEschemeMapper;

    /**
     * 查询装配方案
     * 
     * @param bpeid 装配方案ID
     * @return 装配方案
     */
    @Override
    public TBptEscheme selectTBptEschemeById(Long bpeid)
    {
        return tBptEschemeMapper.selectTBptEschemeById(bpeid);
    }

    /**
     * 查询装配方案列表
     * 
     * @param tBptEscheme 装配方案
     * @return 装配方案
     */
    @Override
    public List<TBptEscheme> selectTBptEschemeList(TBptEscheme tBptEscheme)
    {
        return tBptEschemeMapper.selectTBptEschemeList(tBptEscheme);
    }

    /**
     * 新增装配方案
     * 
     * @param tBptEscheme 装配方案
     * @return 结果
     */
    @Override
    public int insertTBptEscheme(TBptEscheme tBptEscheme)
    {
        tBptEscheme.setCreateTime(DateUtils.getNowDate());
        return tBptEschemeMapper.insertTBptEscheme(tBptEscheme);
    }

    /**
     * 修改装配方案
     * 
     * @param tBptEscheme 装配方案
     * @return 结果
     */
    @Override
    public int updateTBptEscheme(TBptEscheme tBptEscheme)
    {
        return tBptEschemeMapper.updateTBptEscheme(tBptEscheme);
    }

    /**
     * 删除装配方案对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTBptEschemeByIds(String ids)
    {
        return tBptEschemeMapper.deleteTBptEschemeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除装配方案信息
     * 
     * @param bpeid 装配方案ID
     * @return 结果
     */
    @Override
    public int deleteTBptEschemeById(Long bpeid)
    {
        return tBptEschemeMapper.deleteTBptEschemeById(bpeid);
    }
}
