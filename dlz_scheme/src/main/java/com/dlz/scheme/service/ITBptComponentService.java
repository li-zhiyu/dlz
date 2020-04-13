package com.dlz.scheme.service;

import com.dlz.scheme.domain.TBptComponent;
import com.dlz.scheme.domain.TProjectComponent;

import java.util.List;

/**
 * 构件库管理Service接口
 * 
 * @author lizhiyu
 * @date 2020-02-14
 */
public interface ITBptComponentService 
{
    /**
     * 查询构件库管理
     * 
     * @param cpid 构件库管理ID
     * @return 构件库管理
     */
    public TBptComponent selectTBptComponentById(Long cpid);

    /**
     * 查询构件库管理列表
     * 
     * @param tBptComponent 构件库管理
     * @return 构件库管理集合
     */
    public List<TBptComponent> selectTBptComponentList(TBptComponent tBptComponent);

    /**
     * 查询项目未绑定的构件列表
     *
     * @param tBptComponent 构件库管理
     * @return 构件库管理集合
     */
    public List<TBptComponent> selectTBptComponentUnbindList(TBptComponent tBptComponent);

    /**
     * 通过项目ID查询构件库管理列表
     *
     * @param tBptComponent 构件库管理
     * @return 构件库管理集合
     */
    public List<TBptComponent> selectTBptComponentListBypjtid(TBptComponent tBptComponent);

    /**
     * 取消构件绑定
     *
     */
    public int cancel(String pjtid, String cpid);

    /**
     * 新增构件库管理
     * 
     * @param tBptComponent 构件库管理
     * @return 结果
     */
    public int insertTBptComponent(TBptComponent tBptComponent);

    /**
     * 修改构件库管理
     * 
     * @param tBptComponent 构件库管理
     * @return 结果
     */
    public int updateTBptComponent(TBptComponent tBptComponent);

    /**
     * 批量删除构件库管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTBptComponentByIds(String ids);

    /**
     * 删除构件库管理信息
     * 
     * @param cpid 构件库管理ID
     * @return 结果
     */
    public int deleteTBptComponentById(Long cpid);

    public int batchBindComponent(String pjtid, String cpids);
}
