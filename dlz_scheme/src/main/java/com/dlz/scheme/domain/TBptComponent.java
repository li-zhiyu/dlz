package com.dlz.scheme.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dlz.common.annotation.Excel;
import com.dlz.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 构件库管理对象 t_bpt_component
 * 
 * @author lizhiyu
 * @date 2020-02-14
 */
public class TBptComponent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 构件主键 */
    private Long cpid;

    /** 构件名 */
    @Excel(name = "构件名")
    private String cpNm;

    /** 构件编码 */
    @Excel(name = "构件编码")
    private String cpNo;

    /** 类型 */
    @Excel(name = "类型")
    private String cpType;

    /** 子类型 */
    @Excel(name = "子类型")
    private String cpType2;

    /** 文件名 */
    @Excel(name = "文件名")
    private String fileNm;

    /** 文件上传路径 */
    @Excel(name = "文件上传路径")
    private String path;

    /** 备注 */
    @Excel(name = "备注")
    private String memo;

    /** 缩略图文件路径 */
    @Excel(name = "缩略图文件路径")
    private String tblPath;

    /** 录入时间 */
    @Excel(name = "录入时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date editDate;

    /** 长 */
    @Excel(name = "长")
    private String length;

    /** 宽 */
    @Excel(name = "宽")
    private String width;

    /** 高 */
    @Excel(name = "高")
    private String heigth;

    /** 重 */
    @Excel(name = "重")
    private String weigth;

    private String pjtid;

    public String getPjtid() {
        return pjtid;
    }

    public void setPjtid(String pjtid) {
        this.pjtid = pjtid;
    }

    public void setCpid(Long cpid)
    {
        this.cpid = cpid;
    }

    public Long getCpid() 
    {
        return cpid;
    }
    public void setCpNm(String cpNm) 
    {
        this.cpNm = cpNm;
    }

    public String getCpNm() 
    {
        return cpNm;
    }
    public void setCpNo(String cpNo) 
    {
        this.cpNo = cpNo;
    }

    public String getCpNo() 
    {
        return cpNo;
    }
    public void setCpType(String cpType) 
    {
        this.cpType = cpType;
    }

    public String getCpType() 
    {
        return cpType;
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
    public void setTblPath(String tblPath) 
    {
        this.tblPath = tblPath;
    }

    public String getTblPath() 
    {
        return tblPath;
    }
    public void setEditDate(Date editDate) 
    {
        this.editDate = editDate;
    }

    public Date getEditDate() 
    {
        return editDate;
    }
    public void setLength(String length) 
    {
        this.length = length;
    }

    public String getLength() 
    {
        return length;
    }
    public void setWidth(String width) 
    {
        this.width = width;
    }

    public String getWidth() 
    {
        return width;
    }
    public void setHeigth(String heigth) 
    {
        this.heigth = heigth;
    }

    public String getHeigth() 
    {
        return heigth;
    }
    public void setWeigth(String weigth) 
    {
        this.weigth = weigth;
    }

    public String getWeigth() 
    {
        return weigth;
    }

    public String getCpType2() {
        return cpType2;
    }

    public void setCpType2(String cpType2) {
        this.cpType2 = cpType2;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cpid", getCpid())
            .append("cpNm", getCpNm())
            .append("cpNo", getCpNo())
            .append("cpType", getCpType())
            .append("cpType2", getCpType2())
            .append("fileNm", getFileNm())
            .append("path", getPath())
            .append("memo", getMemo())
            .append("tblPath", getTblPath())
            .append("editDate", getEditDate())
            .append("length", getLength())
            .append("width", getWidth())
            .append("heigth", getHeigth())
            .append("weigth", getWeigth())
            .toString();
    }
}
