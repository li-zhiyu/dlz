package com.dlz.scheme.mapper;

import com.dlz.scheme.domain.TProjectComponent;
import java.util.List;

/**
 * 项目-构件关系表Mapper接口
 * 
 * @author lizhiyu
 * @date 2020-03-31
 */
public interface TProjectComponentMapper 
{
    /**
     * 查询项目-构件关系表
     * 
     * @param pjtid 项目-构件关系表ID
     * @return 项目-构件关系表
     */
    public TProjectComponent selectTProjectComponentById(Long pjtid);

    /**
     * 查询项目-构件关系表列表
     * 
     * @param tProjectComponent 项目-构件关系表
     * @return 项目-构件关系表集合
     */
    public List<TProjectComponent> selectTProjectComponentList(TProjectComponent tProjectComponent);

    /**
     * 新增项目-构件关系表
     * 
     * @param tProjectComponent 项目-构件关系表
     * @return 结果
     */
    public int insertTProjectComponent(TProjectComponent tProjectComponent);

    /**
     * 修改项目-构件关系表
     * 
     * @param tProjectComponent 项目-构件关系表
     * @return 结果
     */
    public int updateTProjectComponent(TProjectComponent tProjectComponent);

    /**
     * 删除项目-构件关系表
     * 
     * @param pjtid 项目-构件关系表ID
     * @return 结果
     */
    public int deleteTProjectComponentById(Long pjtid);

    /**
     * 删除项目-构件关系表
     *
     * @param tProjectComponent
     * @return 结果
     */
    public int deleteByPjtidAndCpid(TProjectComponent tProjectComponent);

    /**
     * 批量删除项目-构件关系表
     * 
     * @param pjtids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTProjectComponentByIds(String[] pjtids);


    public int batchBindComponent(List<TProjectComponent> tProjectComponents);
}
