package com.dlz.scheme.mapper;

import com.dlz.scheme.domain.TProjectInfo;
import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author lizhiyu
 * @date 2020-03-23
 */
public interface TProjectInfoMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param pjtid 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public TProjectInfo selectTProjectInfoById(String pjtid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tProjectInfo 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TProjectInfo> selectTProjectInfoList(TProjectInfo tProjectInfo);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tProjectInfo 【请填写功能名称】
     * @return 结果
     */
    public int insertTProjectInfo(TProjectInfo tProjectInfo);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tProjectInfo 【请填写功能名称】
     * @return 结果
     */
    public int updateTProjectInfo(TProjectInfo tProjectInfo);

    /**
     * 删除【请填写功能名称】
     * 
     * @param pjtid 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteTProjectInfoById(String pjtid);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param pjtids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTProjectInfoByIds(String[] pjtids);
}
