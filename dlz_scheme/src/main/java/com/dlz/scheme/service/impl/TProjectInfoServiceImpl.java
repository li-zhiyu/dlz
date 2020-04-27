package com.dlz.scheme.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dlz.common.annotation.DataScope;
import com.dlz.common.constant.UserConstants;
import com.dlz.common.core.domain.Ztree;
import com.dlz.common.utils.DateUtils;
import com.dlz.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dlz.scheme.mapper.TProjectInfoMapper;
import com.dlz.scheme.domain.TProjectInfo;
import com.dlz.scheme.service.ITProjectInfoService;
import com.dlz.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author lizhiyu
 * @date 2020-03-23
 */
@Service
public class TProjectInfoServiceImpl implements ITProjectInfoService 
{
    @Autowired
    private TProjectInfoMapper tProjectInfoMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param pjtid 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public TProjectInfo selectTProjectInfoById(String pjtid)
    {
        return tProjectInfoMapper.selectTProjectInfoById(pjtid);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tProjectInfo 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TProjectInfo> selectTProjectInfoList(TProjectInfo tProjectInfo)
    {
        return tProjectInfoMapper.selectTProjectInfoList(tProjectInfo);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param tProjectInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTProjectInfo(TProjectInfo tProjectInfo)
    {
        tProjectInfo.setCreateTime(DateUtils.getNowDate());
        return tProjectInfoMapper.insertTProjectInfo(tProjectInfo);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param tProjectInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTProjectInfo(TProjectInfo tProjectInfo)
    {
        return tProjectInfoMapper.updateTProjectInfo(tProjectInfo);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTProjectInfoByIds(String ids)
    {
        return tProjectInfoMapper.deleteTProjectInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param pjtid 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteTProjectInfoById(String pjtid)
    {
        return tProjectInfoMapper.deleteTProjectInfoById(pjtid);
    }


    @Override
    public List<Ztree> selectProjectTree()
    {
        List<TProjectInfo> projectList = tProjectInfoMapper.selectTProjectInfoList(null);
        List<Ztree> ztrees = initZtree(projectList);
        return ztrees;
    }

    public List<Ztree> initZtree(List<TProjectInfo> projectList)
    {

        List<Ztree> ztrees = new ArrayList<Ztree>();
        Ztree ztreeP = new Ztree();
        ztreeP.setId(1L);
        ztreeP.setpId(0L);
        ztreeP.setName("项目库");
        ztreeP.setTitle("项目库");
        ztrees.add(ztreeP);
        for (TProjectInfo projectInfo : projectList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(Long.valueOf(projectInfo.getPjtid()));
            ztree.setpId(1L);
            ztree.setName(projectInfo.getPjtNm());
            ztree.setTitle(projectInfo.getPjtNm());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
