package com.dlz.scheme.mapper;

import com.dlz.scheme.domain.TProjectScheme;
import java.util.List;

/**
 * 方案管理Mapper接口
 * 
 * @author lizhiyu
 * @date 2020-04-16
 */
public interface TProjectSchemeMapper 
{
    /**
     * 查询方案管理
     * 
     * @param faid 方案管理ID
     * @return 方案管理
     */
    public TProjectScheme selectTProjectSchemeById(Long faid);

    /**
     * 查询方案管理列表
     * 
     * @param tProjectScheme 方案管理
     * @return 方案管理集合
     */
    public List<TProjectScheme> selectTProjectSchemeList(TProjectScheme tProjectScheme);

    /**
     * 新增方案管理
     * 
     * @param tProjectScheme 方案管理
     * @return 结果
     */
    public int insertTProjectScheme(TProjectScheme tProjectScheme);

    /**
     * 修改方案管理
     * 
     * @param tProjectScheme 方案管理
     * @return 结果
     */
    public int updateTProjectScheme(TProjectScheme tProjectScheme);

    /**
     * 删除方案管理
     * 
     * @param faid 方案管理ID
     * @return 结果
     */
    public int deleteTProjectSchemeById(Long faid);

    /**
     * 批量删除方案管理
     * 
     * @param faids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTProjectSchemeByIds(String[] faids);
}
