package com.dlz.scheme.mapper;

import com.dlz.scheme.domain.TScemeDictdata;
import com.dlz.system.domain.SysUserPost;

import java.util.List;

/**
 * 方案与预制构件关系Mapper接口
 * 
 * @author lizhiyu
 * @date 2020-04-17
 */
public interface TScemeDictdataMapper 
{
    /**
     * 查询方案与预制构件关系
     * 
     * @param faid 方案与预制构件关系ID
     * @return 方案与预制构件关系
     */
    public TScemeDictdata selectTScemeDictdataById(Long faid);

    /**
     * 查询方案与预制构件关系列表
     * 
     * @param tScemeDictdata 方案与预制构件关系
     * @return 方案与预制构件关系集合
     */
    public List<TScemeDictdata> selectTScemeDictdataList(TScemeDictdata tScemeDictdata);

    /**
     * 新增方案与预制构件关系
     * 
     * @param tScemeDictdata 方案与预制构件关系
     * @return 结果
     */
    public int insertTScemeDictdata(TScemeDictdata tScemeDictdata);

    /**
     * 修改方案与预制构件关系
     * 
     * @param tScemeDictdata 方案与预制构件关系
     * @return 结果
     */
    public int updateTScemeDictdata(TScemeDictdata tScemeDictdata);

    /**
     * 删除方案与预制构件关系
     * 
     * @param faid 方案与预制构件关系ID
     * @return 结果
     */
    public int deleteTScemeDictdataById(Long faid);

    /**
     * 批量删除方案与预制构件关系
     * 
     * @param faids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTScemeDictdataByIds(String[] faids);

    /**
     * 批量新增方案与预制构件关系
     *
     * @param list 插入列表
     * @return 结果
     */

    public int batchInsertTScemeDictdata(List<TScemeDictdata> list);
}
