package com.dlz.scheme.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dlz.common.annotation.Excel;
import com.dlz.common.core.domain.BaseEntity;

/**
 * 方案文件管理对象 t_bpt_main_file
 * 
 * @author lizhiyu
 * @date 2020-02-26
 */
public class TBptMainFile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 方案ID */
    @Excel(name = "方案ID")
    private String bptid;

    /** 文件分类 */
    @Excel(name = "文件分类")
    private String fileType;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String fileName;

    /** 文件上传地址 */
    @Excel(name = "文件上传地址")
    private String path;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creator;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setBptid(String bptid)
    {
        this.bptid = bptid;
    }

    public String getBptid()
    {
        return bptid;
    }
    public void setFileType(String fileType) 
    {
        this.fileType = fileType;
    }

    public String getFileType() 
    {
        return fileType;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setPath(String path) 
    {
        this.path = path;
    }

    public String getPath() 
    {
        return path;
    }
    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bptid", getBptid())
            .append("fileType", getFileType())
            .append("fileName", getFileName())
            .append("path", getPath())
            .append("creator", getCreator())
            .append("createTime", getCreateTime())
            .toString();
    }
}
