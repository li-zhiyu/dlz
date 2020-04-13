package com.dlz.scheme.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dlz.common.annotation.Excel;
import com.dlz.common.core.domain.BaseEntity;

/**
 * 节点库对象 t_bpt_componentnode
 * 
 * @author lizhiyu
 * @date 2019-12-12
 */
public class TBptComponentnode extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 构件节点主键 */
    private Long cnid;

    /** 构件节点名 */
    @Excel(name = "构件节点名")
    private String cnNm;

    /** 构件节点编码 */
    @Excel(name = "构件节点编码")
    private String cnNo;

    /** 类型 */
    @Excel(name = "类型")
    private String cnType;

    /** 子类型 */
    @Excel(name = "子类型")
    private String cnType2;

    /** 文件名 */
    @Excel(name = "文件名")
    private String fileNm;

    /** 文件上传路径 */
    @Excel(name = "文件上传路径")
    private String path;

    /** 备注 */
    @Excel(name = "备注")
    private String memo;

    private String pjtid;

    public String getPjtid() {
        return pjtid;
    }

    public void setPjtid(String pjtid) {
        this.pjtid = pjtid;
    }

    public void setCnid(Long cnid)
    {
        this.cnid = cnid;
    }

    public Long getCnid() 
    {
        return cnid;
    }
    public void setCnNm(String cnNm) 
    {
        this.cnNm = cnNm;
    }

    public String getCnNm() 
    {
        return cnNm;
    }
    public void setCnNo(String cnNo) 
    {
        this.cnNo = cnNo;
    }

    public String getCnNo() 
    {
        return cnNo;
    }
    public void setCnType(String cnType) 
    {
        this.cnType = cnType;
    }

    public String getCnType() 
    {
        return cnType;
    }
    public void setFileNm(String fileNm) 
    {
        this.fileNm = fileNm;
    }

    public String getFileNm() 
    {
        return fileNm;
    }
    public void setPath(String path) 
    {
        this.path = path;
    }

    public String getPath() 
    {
        return path;
    }
    public void setMemo(String memo) 
    {
        this.memo = memo;
    }

    public String getMemo() 
    {
        return memo;
    }

    public String getCnType2() {
        return cnType2;
    }

    public void setCnType2(String cnType2) {
        this.cnType2 = cnType2;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cnid", getCnid())
            .append("cnNm", getCnNm())
            .append("cnNo", getCnNo())
            .append("cnType", getCnType())
            .append("cnType2", getCnType2())
            .append("fileNm", getFileNm())
            .append("path", getPath())
            .append("memo", getMemo())
            .toString();
    }
}
