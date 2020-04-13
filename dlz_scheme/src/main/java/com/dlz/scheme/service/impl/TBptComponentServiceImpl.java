package com.dlz.scheme.service.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dlz.common.utils.DateUtils;
import com.dlz.scheme.domain.TProjectComponent;
import com.dlz.scheme.mapper.TProjectComponentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dlz.scheme.mapper.TBptComponentMapper;
import com.dlz.scheme.domain.TBptComponent;
import com.dlz.scheme.service.ITBptComponentService;
import com.dlz.common.core.text.Convert;

/**
 * 构件库管理Service业务层处理
 * 
 * @author lizhiyu
 * @date 2020-02-14
 */
@Service
public class TBptComponentServiceImpl implements ITBptComponentService 
{
    @Autowired
    private TBptComponentMapper tBptComponentMapper;

    @Autowired
    private TProjectComponentMapper tProjectComponentMapper;

    /**
     * 查询构件库管理
     * 
     * @param cpid 构件库管理ID
     * @return 构件库管理
     */
    @Override
    public TBptComponent selectTBptComponentById(Long cpid)
    {
        return tBptComponentMapper.selectTBptComponentById(cpid);
    }

    /**
     * 查询构件库管理列表
     * 
     * @param tBptComponent 构件库管理
     * @return 构件库管理
     */
    @Override
    public List<TBptComponent> selectTBptComponentList(TBptComponent tBptComponent)
    {
        return tBptComponentMapper.selectTBptComponentList(tBptComponent);
    }

    /**
     * 查询未绑定的构件列表
     *
     * @param tBptComponent 构件库管理
     * @return 构件库管理
     */
    @Override
    public List<TBptComponent> selectTBptComponentUnbindList(TBptComponent tBptComponent)
    {
        return tBptComponentMapper.selectTBptComponentUnbindList(tBptComponent);
    }

    /**
     * 通过项目ID查询构件库管理列表
     *
     * @param tBptComponent 构件库管理
     * @return 构件库管理
     */
    @Override
    public List<TBptComponent> selectTBptComponentListBypjtid(TBptComponent tBptComponent)
    {
        return tBptComponentMapper.selectTBptComponentListBypjtid(tBptComponent);
    }

    /**
     * 取消构件绑定
     */
    @Override
    public int cancel(String pjtid, String cpid)
    {
        TProjectComponent tProjectComponent = new TProjectComponent();
        tProjectComponent.setCpid(Long.valueOf(cpid));
        tProjectComponent.setPjtid(Long.valueOf(pjtid));
        return tProjectComponentMapper.deleteByPjtidAndCpid(tProjectComponent);
    }

    /**
     * 新增构件库管理
     * 
     * @param tBptComponent 构件库管理
     * @return 结果
     */
    @Override
    public int insertTBptComponent(TBptComponent tBptComponent)
    {
        tBptComponent.setEditDate(DateUtils.getNowDate());
        return tBptComponentMapper.insertTBptComponent(tBptComponent);
    }

    /**
     * 修改构件库管理
     * 
     * @param tBptComponent 构件库管理
     * @return 结果
     */
    @Override
    public int updateTBptComponent(TBptComponent tBptComponent)
    {
        return tBptComponentMapper.updateTBptComponent(tBptComponent);
    }

    /**
     * 删除构件库管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTBptComponentByIds(String ids)
    {
        return tBptComponentMapper.deleteTBptComponentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除构件库管理信息
     * 
     * @param cpid 构件库管理ID
     * @return 结果
     */
    @Override
    public int deleteTBptComponentById(Long cpid)
    {
        return tBptComponentMapper.deleteTBptComponentById(cpid);
    }

    @Override
    public int batchBindComponent(String pjtid, String cpids) {
        if (cpids!=null){
            String[] arrayCpid = cpids.split(",");
            List<TProjectComponent> list = new ArrayList<TProjectComponent>();
            for (int i = 0; i < arrayCpid.length; i++) {
                list.add(new TProjectComponent(Long.valueOf(pjtid),Long.valueOf(arrayCpid[i])));
            }
            return tProjectComponentMapper.batchBindComponent(list);
        }
        return 0;
    }
}
