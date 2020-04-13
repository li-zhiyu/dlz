package com.dlz.scheme.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dlz.scheme.domain.TBptComponent;
import com.dlz.scheme.domain.TProjectComponent;
import com.dlz.scheme.domain.TProjectComponentnode;
import com.dlz.scheme.mapper.TProjectComponentMapper;
import com.dlz.scheme.mapper.TProjectComponentnodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dlz.scheme.mapper.TBptComponentnodeMapper;
import com.dlz.scheme.domain.TBptComponentnode;
import com.dlz.scheme.service.ITBptComponentnodeService;
import com.dlz.common.core.text.Convert;

/**
 * 节点库Service业务层处理
 * 
 * @author lizhiyu
 * @date 2019-12-12
 */
@Service
public class TBptComponentnodeServiceImpl implements ITBptComponentnodeService 
{
    @Autowired
    private TBptComponentnodeMapper tBptComponentnodeMapper;

    @Autowired
    private TProjectComponentnodeMapper tProjectComponentnodeMapper;


    /**
     * 查询节点库
     * 
     * @param cnid 节点库ID
     * @return 节点库
     */
    @Override
    public TBptComponentnode selectTBptComponentnodeById(Long cnid)
    {
        return tBptComponentnodeMapper.selectTBptComponentnodeById(cnid);
    }

    /**
     * 查询节点库列表
     * 
     * @param tBptComponentnode 节点库
     * @return 节点库
     */
    @Override
    public List<TBptComponentnode> selectTBptComponentnodeList(TBptComponentnode tBptComponentnode)
    {
        return tBptComponentnodeMapper.selectTBptComponentnodeList(tBptComponentnode);
    }

    /**
     * 新增节点库
     * 
     * @param tBptComponentnode 节点库
     * @return 结果
     */
    @Override
    public int insertTBptComponentnode(TBptComponentnode tBptComponentnode)
    {
        return tBptComponentnodeMapper.insertTBptComponentnode(tBptComponentnode);
    }

    /**
     * 修改节点库
     * 
     * @param tBptComponentnode 节点库
     * @return 结果
     */
    @Override
    public int updateTBptComponentnode(TBptComponentnode tBptComponentnode)
    {
        return tBptComponentnodeMapper.updateTBptComponentnode(tBptComponentnode);
    }

    /**
     * 删除节点库对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTBptComponentnodeByIds(String ids)
    {
        return tBptComponentnodeMapper.deleteTBptComponentnodeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除节点库信息
     * 
     * @param cnid 节点库ID
     * @return 结果
     */
    @Override
    public int deleteTBptComponentnodeById(Long cnid)
    {
        return tBptComponentnodeMapper.deleteTBptComponentnodeById(cnid);
    }

    /**
     * 取消节点绑定
     */
    @Override
    public int cancel(String pjtid, String cnid)
    {
        TProjectComponentnode tProjectComponentnode = new TProjectComponentnode();
        tProjectComponentnode.setCnid(Long.valueOf(cnid));
        tProjectComponentnode.setPjtid(Long.valueOf(pjtid));
        return tProjectComponentnodeMapper.deleteByPjtidAndCnid(tProjectComponentnode);
    }
    /**
     * 批量绑定
     */
    @Override
    public int batchBindComponentNode(String pjtid, String cnids) {
        if (cnids!=null){
            String[] arrayCnid = cnids.split(",");
            List<TProjectComponentnode> list = new ArrayList<TProjectComponentnode>();
            for (int i = 0; i < arrayCnid.length; i++) {
                list.add(new TProjectComponentnode(Long.valueOf(pjtid),Long.valueOf(arrayCnid[i])));
            }
            return tProjectComponentnodeMapper.batchBindComponentNode(list);
        }
        return 0;
    }

    /**
     * 查询未绑定的构件列表
     *
     * @param tBptComponentnode 构件库管理
     * @return 构件库管理
     */
    @Override
    public List<TBptComponent> selectTBptComponentnodeUnbindList(TBptComponentnode tBptComponentnode)
    {
        return tBptComponentnodeMapper.selectTBptComponentNodeUnbindList(tBptComponentnode);
    }

    /**
     * 通过项目ID查询构件库管理列表
     *
     * @param tBptComponentnode 构件库管理
     * @return 构件库管理
     */
    @Override
    public List<TBptComponent> selectTBptComponentnodeListBypjtid(TBptComponentnode tBptComponentnode)
    {
        return tBptComponentnodeMapper.selectTBptComponentNodeListBypjtid(tBptComponentnode);
    }


}
