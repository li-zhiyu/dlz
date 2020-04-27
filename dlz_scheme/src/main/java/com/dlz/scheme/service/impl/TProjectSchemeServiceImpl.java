package com.dlz.scheme.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dlz.scheme.mapper.TProjectSchemeMapper;
import com.dlz.scheme.domain.TProjectScheme;
import com.dlz.scheme.service.ITProjectSchemeService;
import com.dlz.common.core.text.Convert;

/**
 * 方案管理Service业务层处理
 * 
 * @author lizhiyu
 * @date 2020-04-16
 */
@Service
public class TProjectSchemeServiceImpl implements ITProjectSchemeService 
{
    @Autowired
    private TProjectSchemeMapper tProjectSchemeMapper;

    /**
     * 查询方案管理
     * 
     * @param faid 方案管理ID
     * @return 方案管理
     */
    @Override
    public TProjectScheme selectTProjectSchemeById(Long faid)
    {
        return tProjectSchemeMapper.selectTProjectSchemeById(faid);
    }

    /**
     * 查询方案管理列表
     * 
     * @param tProjectScheme 方案管理
     * @return 方案管理
     */
    @Override
    public List<TProjectScheme> selectTProjectSchemeList(TProjectScheme tProjectScheme)
    {
        return tProjectSchemeMapper.selectTProjectSchemeList(tProjectScheme);
    }

    /**
     * 新增方案管理
     * 
     * @param tProjectScheme 方案管理
     * @return 结果
     */
    @Override
    public int insertTProjectScheme(TProjectScheme tProjectScheme)
    {
        tProjectScheme.setCreateTime(DateUtils.getNowDate());
        return tProjectSchemeMapper.insertTProjectScheme(tProjectScheme);
    }

    /**
     * 修改方案管理
     * 
     * @param tProjectScheme 方案管理
     * @return 结果
     */
    @Override
    public int updateTProjectScheme(TProjectScheme tProjectScheme)
    {
        return tProjectSchemeMapper.updateTProjectScheme(tProjectScheme);
    }

    /**
     * 删除方案管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTProjectSchemeByIds(String ids)
    {
        return tProjectSchemeMapper.deleteTProjectSchemeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除方案管理信息
     * 
     * @param faid 方案管理ID
     * @return 结果
     */
    @Override
    public int deleteTProjectSchemeById(Long faid)
    {
        return tProjectSchemeMapper.deleteTProjectSchemeById(faid);
    }
}
