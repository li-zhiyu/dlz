package com.dlz.scheme.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dlz.common.annotation.Excel;
import com.dlz.common.core.domain.BaseEntity;

/**
 * 项目文件管理对象 t_project_file
 * 
 * @author lizhiyu
 * @date 2020-03-27
 */
public class TProjectFile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 方案ID */
    @Excel(name = "方案ID")
    private String pjtid;

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

    /** bimface返回的fileId */
    @Excel(name = "bimface返回的fileId")
    private String fileId;

    /** 文件格式 */
    @Excel(name = "文件格式")
    private String fileFormat;

    /** 文件状态 */
    @Excel(name = "文件格式")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPjtid(String pjtid) 
    {
        this.pjtid = pjtid;
    }

    public String getPjtid() 
    {
        return pjtid;
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
    public void setFileId(String fileId) 
    {
        this.fileId = fileId;
    }

    public String getFileId() 
    {
        return fileId;
    }
    public void setFileFormat(String fileFormat) 
    {
        this.fileFormat = fileFormat;
    }

    public String getFileFormat() 
    {
        return fileFormat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pjtid", getPjtid())
            .append("fileType", getFileType())
            .append("fileName", getFileName())
            .append("path", getPath())
            .append("creator", getCreator())
            .append("createTime", getCreateTime())
            .append("fileId", getFileId())
            .append("fileFormat", getFileFormat())
            .append("status", getStatus())
            .toString();
    }
}
