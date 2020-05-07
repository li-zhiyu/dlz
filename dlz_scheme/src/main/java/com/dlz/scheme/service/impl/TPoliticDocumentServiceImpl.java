package com.dlz.scheme.service.impl;

import java.util.List;
import com.dlz.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dlz.scheme.mapper.TPoliticDocumentMapper;
import com.dlz.scheme.domain.TPoliticDocument;
import com.dlz.scheme.service.ITPoliticDocumentService;
import com.dlz.common.core.text.Convert;

/**
 * 政策文件Service业务层处理
 * 
 * @author lizhiyu
 * @date 2020-05-05
 */
@Service
public class TPoliticDocumentServiceImpl implements ITPoliticDocumentService 
{
    @Autowired
    private TPoliticDocumentMapper tPoliticDocumentMapper;

    /**
     * 查询政策文件
     * 
     * @param pdid 政策文件ID
     * @return 政策文件
     */
    @Override
    public TPoliticDocument selectTPoliticDocumentById(Long pdid)
    {
        return tPoliticDocumentMapper.selectTPoliticDocumentById(pdid);
    }

    /**
     * 查询政策文件列表
     * 
     * @param tPoliticDocument 政策文件
     * @return 政策文件
     */
    @Override
    public List<TPoliticDocument> selectTPoliticDocumentList(TPoliticDocument tPoliticDocument)
    {
        return tPoliticDocumentMapper.selectTPoliticDocumentList(tPoliticDocument);
    }

    /**
     * 新增政策文件
     * 
     * @param tPoliticDocument 政策文件
     * @return 结果
     */
    @Override
    public int insertTPoliticDocument(TPoliticDocument tPoliticDocument)
    {
        tPoliticDocument.setCreateTime(DateUtils.getNowDate());
        return tPoliticDocumentMapper.insertTPoliticDocument(tPoliticDocument);
    }

    /**
     * 修改政策文件
     * 
     * @param tPoliticDocument 政策文件
     * @return 结果
     */
    @Override
    public int updateTPoliticDocument(TPoliticDocument tPoliticDocument)
    {
        return tPoliticDocumentMapper.updateTPoliticDocument(tPoliticDocument);
    }

    /**
     * 删除政策文件对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTPoliticDocumentByIds(String ids)
    {
        return tPoliticDocumentMapper.deleteTPoliticDocumentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除政策文件信息
     * 
     * @param pdid 政策文件ID
     * @return 结果
     */
    @Override
    public int deleteTPoliticDocumentById(Long pdid)
    {
        return tPoliticDocumentMapper.deleteTPoliticDocumentById(pdid);
    }
}
