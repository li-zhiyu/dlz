package com.dlz.scheme.mapper;

import com.dlz.scheme.domain.TProjectComponent;
import com.dlz.scheme.domain.TProjectComponentnode;
import java.util.List;

/**
 * 项目-节点关系绑定Mapper接口
 * 
 * @author lizhiyu
 * @date 2020-04-01
 */
public interface TProjectComponentnodeMapper 
{
    /**
     * 查询项目-节点关系绑定
     * 
     * @param pjtid 项目-节点关系绑定ID
     * @return 项目-节点关系绑定
     */
    public TProjectComponentnode selectTProjectComponentnodeById(Long pjtid);

    /**
     * 查询项目-节点关系绑定列表
     * 
     * @param tProjectComponentnode 项目-节点关系绑定
     * @return 项目-节点关系绑定集合
     */
    public List<TProjectComponentnode> selectTProjectComponentnodeList(TProjectComponentnode tProjectComponentnode);

    /**
     * 新增项目-节点关系绑定
     * 
     * @param tProjectComponentnode 项目-节点关系绑定
     * @return 结果
     */
    public int insertTProjectComponentnode(TProjectComponentnode tProjectComponentnode);

    /**
     * 修改项目-节点关系绑定
     * 
     * @param tProjectComponentnode 项目-节点关系绑定
     * @return 结果
     */
    public int updateTProjectComponentnode(TProjectComponentnode tProjectComponentnode);

    /**
     * 删除项目-节点关系绑定
     * 
     * @param pjtid 项目-节点关系绑定ID
     * @return 结果
     */
    public int deleteTProjectComponentnodeById(Long pjtid);

    /**
     * 批量删除项目-节点关系绑定
     * 
     * @param pjtids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTProjectComponentnodeByIds(String[] pjtids);
    /**
     * 删除项目-构件关系表
     *
     * @param tProjectComponentnode
     * @return 结果
     */
    public int deleteByPjtidAndCnid(TProjectComponentnode tProjectComponentnode);
    /**
     * 批量绑定
     *
     * @param tProjectComponentnodes
     * @return 结果
     */
    public int batchBindComponentNode(List<TProjectComponentnode> tProjectComponentnodes);
}
