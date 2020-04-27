package com.dlz.scheme.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.dlz.common.utils.DateUtils;
import com.dlz.common.utils.StringUtils;
import com.dlz.scheme.domain.TScemeDictdata;
import com.dlz.scheme.mapper.TScemeDictdataMapper;
import com.dlz.system.domain.SysUser;
import com.dlz.system.domain.SysUserPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dlz.scheme.mapper.TProjectSchemeMapper;
import com.dlz.scheme.domain.TProjectScheme;
import com.dlz.scheme.service.ITProjectSchemeService;
import com.dlz.common.core.text.Convert;
import com.dlz.framework.util.ShiroUtils;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private TScemeDictdataMapper tScemeDictdataMapper;

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
    @Transactional
    public int insertTProjectScheme(TProjectScheme tProjectScheme)
    {
        tProjectScheme.setCreateTime(DateUtils.getNowDate());
        tProjectScheme.setCreator(ShiroUtils.getLoginName());
        if ( "on".equals(tProjectScheme.getIsDefault())){
            tProjectScheme.setIsDefault("Y");
        }else {
            tProjectScheme.setIsDefault("N");
        }
        //如果当前方案为默认方案则取消已有的默认方案
        if ("Y".equals(tProjectScheme.getIsDefault())){
            TProjectScheme tProjectScheme1 = new TProjectScheme();
            tProjectScheme1.setPjtid(tProjectScheme.getPjtid());
            tProjectScheme1.setIsDefault("N");
            tProjectSchemeMapper.updateTProjectSchemes(tProjectScheme1);
        }
        //新增方案信息
        int row = tProjectSchemeMapper.insertTProjectScheme(tProjectScheme);
        //新增方案与预制构件关系
        insertSchemeComponents(tProjectScheme);

        return row;
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
        if ( "on".equals(tProjectScheme.getIsDefault())){
            tProjectScheme.setIsDefault("Y");
        }else {
            tProjectScheme.setIsDefault("N");
        }
        return tProjectSchemeMapper.updateTProjectScheme(tProjectScheme);
    }

    /**
     * 删除方案管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteTProjectSchemeByIds(String ids)
    {
        //删除方案下面所有绑定的预制构件
        tScemeDictdataMapper.deleteTScemeDictdataByIds(Convert.toStrArray(ids));
        //删除方案
        int i = tProjectSchemeMapper.deleteTProjectSchemeByIds(Convert.toStrArray(ids));
        return i;
    }

    /**
     * 删除方案管理信息
     * 
     * @param faid 方案管理ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteTProjectSchemeById(Long faid)
    {
        //删除方案下面所有绑定的预制构件
        tScemeDictdataMapper.deleteTScemeDictdataById(faid);
        //删除方案
        int i = tProjectSchemeMapper.deleteTProjectSchemeById(faid);
        return i;
    }

    /**
     * 新增方案与预制构件关系
     *
     * @param tProjectScheme 方案
     */
    public void insertSchemeComponents(TProjectScheme tProjectScheme)
    {
        Long[] yzcomponentsIds = tProjectScheme.getYzcomponentsIds();
        if (StringUtils.isNotEmpty(yzcomponentsIds)){
            ArrayList<TScemeDictdata> list = new ArrayList<>();
            for (Long yzcomponentsId : yzcomponentsIds) {
                TScemeDictdata tScemeDictdata = new TScemeDictdata();
                tScemeDictdata.setFaid(tProjectScheme.getFaid());
                tScemeDictdata.setDictCode(yzcomponentsId);
                list.add(tScemeDictdata);
            }
            if (list.size()>0){
                tScemeDictdataMapper.batchInsertTScemeDictdata(list);
            }

        }
    }

    /**
     * 设置默认方案
     * @param tProjectScheme
     * @return
     */
    @Override
    @Transactional
    public int setDefaultScheme(TProjectScheme tProjectScheme) {
        //取消已有的默认方案
        TProjectScheme tProjectScheme1 = new TProjectScheme();
        tProjectScheme1.setPjtid(tProjectScheme.getPjtid());
        tProjectScheme1.setIsDefault("N");
        tProjectSchemeMapper.updateTProjectSchemes(tProjectScheme1);

        //设置当前方案为默认方案
        tProjectScheme.setIsDefault("Y");
        int i = tProjectSchemeMapper.updateTProjectScheme(tProjectScheme);
        return i;
    }
}
