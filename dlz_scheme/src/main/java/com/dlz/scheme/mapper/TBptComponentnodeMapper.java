package com.dlz.scheme.mapper;

import com.dlz.scheme.domain.TBptComponent;
import com.dlz.scheme.domain.TBptComponentnode;
import java.util.List;

/**
 * 节点库Mapper接口
 * 
 * @author lizhiyu
 * @date 2019-12-12
 */
public interface TBptComponentnodeMapper 
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
     * 查询未绑定的节点列表
     *
     * @param tBptComponentnode 构件库管理
     * @return 构件库管理集合
     */
    public List<TBptComponent> selectTBptComponentNodeUnbindList(TBptComponentnode tBptComponentnode);

    /**
     * 通过项目ID查询节点列表
     *
     * @param tBptComponentnode 构件库管理
     * @return 构件库管理集合
     */
    public List<TBptComponent> selectTBptComponentNodeListBypjtid(TBptComponentnode tBptComponentnode);

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
     * 删除节点库
     * 
     * @param cnid 节点库ID
     * @return 结果
     */
    public int deleteTBptComponentnodeById(Long cnid);

    /**
     * 批量删除节点库
     * 
     * @param cnids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTBptComponentnodeByIds(String[] cnids);
}
