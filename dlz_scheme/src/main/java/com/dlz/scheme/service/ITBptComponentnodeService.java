package com.dlz.scheme.service;

import com.dlz.scheme.domain.TBptComponent;
import com.dlz.scheme.domain.TBptComponentnode;
import com.dlz.scheme.domain.TProjectComponent;

import java.util.List;

/**
 * 节点库Service接口
 * 
 * @author lizhiyu
 * @date 2019-12-12
 */
public interface ITBptComponentnodeService 
{
    /**
     * 查询节点库
     * 
     * @param cnid 节点库ID
     * @return 节点库
     */
    public TBptComponentnode selectTBptComponentnodeById(Long cnid);

    /**
     * 查询节点库列表
     * 
     * @param tBptComponentnode 节点库
     * @return 节点库集合
     */
    public List<TBptComponentnode> selectTBptComponentnodeList(TBptComponentnode tBptComponentnode);
    /**
     * 查询项目未绑定的构件列表
     *
     * @param tBptComponentnode 构件库管理
     * @return 构件库管理集合
     */
    public List<TBptComponent> selectTBptComponentnodeUnbindList(TBptComponentnode tBptComponentnode);

    /**
     * 通过项目ID查询构件库管理列表
     *
     * @param tBptComponentnode 构件库管理
     * @return 构件库管理集合
     */
    public List<TBptComponent> selectTBptComponentnodeListBypjtid(TBptComponentnode tBptComponentnode);

    /**
     * 新增节点库
     * 
     * @param tBptComponentnode 节点库
     * @return 结果
     */
    public int insertTBptComponentnode(TBptComponentnode tBptComponentnode);

    /**
     * 修改节点库
     * 
     * @param tBptComponentnode 节点库
     * @return 结果
     */
    public int updateTBptComponentnode(TBptComponentnode tBptComponentnode);

    /**
     * 批量删除节点库
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTBptComponentnodeByIds(String ids);

    /**
     * 删除节点库信息
     * 
     * @param cnid 节点库ID
     * @return 结果
     */
    public int deleteTBptComponentnodeById(Long cnid);

    /**
     * 取消节点绑定
     *
     */
    public int cancel(String pjtid, String cnid);
    /**
     * 批量绑定节点
     *
     */
    public int batchBindComponentNode(String pjtid, String cnids);

}
