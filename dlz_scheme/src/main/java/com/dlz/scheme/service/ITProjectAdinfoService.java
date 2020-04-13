package com.dlz.scheme.service;

import com.dlz.scheme.domain.TProjectAdinfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 方案对比数据Service接口
 * 
 * @author lizhiyu
 * @date 2020-04-03
 */
public interface ITProjectAdinfoService 
{
    /**
     * 查询方案对比数据
     * 
     * @param padid 方案对比数据ID
     * @return 方案对比数据
     */
    public TProjectAdinfo selectTProjectAdinfoById(Long padid);

    /**
     * 查询方案对比数据列表
     * 
     * @param tProjectAdinfo 方案对比数据
     * @return 方案对比数据集合
     */
    public List<TProjectAdinfo> selectTProjectAdinfoList(TProjectAdinfo tProjectAdinfo);

    /**
     * 新增方案对比数据
     * 
     * @param tProjectAdinfo 方案对比数据
     * @return 结果
     */
    public int insertTProjectAdinfo(TProjectAdinfo tProjectAdinfo);

    /**
     * 修改方案对比数据
     * 
     * @param tProjectAdinfo 方案对比数据
     * @return 结果
     */
    public int updateTProjectAdinfo(TProjectAdinfo tProjectAdinfo);

    /**
     * 批量删除方案对比数据
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTProjectAdinfoByIds(String ids);

    /**
     * 删除方案对比数据信息
     * 
     * @param padid 方案对比数据ID
     * @return 结果
     */
    public int deleteTProjectAdinfoById(Long padid);

    public int importExcelData(MultipartFile file,Long pjtid) throws IOException;
}
