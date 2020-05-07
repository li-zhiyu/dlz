package com.dlz.scheme.mapper;

import com.dlz.scheme.domain.TPoliticDocument;
import java.util.List;

/**
 * 政策文件Mapper接口
 * 
 * @author lizhiyu
 * @date 2020-05-05
 */
public interface TPoliticDocumentMapper 
{
    /**
     * 查询政策文件
     * 
     * @param pdid 政策文件ID
     * @return 政策文件
     */
    public TPoliticDocument selectTPoliticDocumentById(Long pdid);

    /**
     * 查询政策文件列表
     * 
     * @param tPoliticDocument 政策文件
     * @return 政策文件集合
     */
    public List<TPoliticDocument> selectTPoliticDocumentList(TPoliticDocument tPoliticDocument);

    /**
     * 新增政策文件
     * 
     * @param tPoliticDocument 政策文件
     * @return 结果
     */
    public int insertTPoliticDocument(TPoliticDocument tPoliticDocument);

    /**
     * 修改政策文件
     * 
     * @param tPoliticDocument 政策文件
     * @return 结果
     */
    public int updateTPoliticDocument(TPoliticDocument tPoliticDocument);

    /**
     * 删除政策文件
     * 
     * @param pdid 政策文件ID
     * @return 结果
     */
    public int deleteTPoliticDocumentById(Long pdid);

    /**
     * 批量删除政策文件
     * 
     * @param pdids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTPoliticDocumentByIds(String[] pdids);
}
