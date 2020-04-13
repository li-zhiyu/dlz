package com.dlz.scheme.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dlz.common.annotation.Excel;
import com.dlz.common.core.domain.BaseEntity;

/**
 * 方案管理对象 t_bpt_main
 * 
 * @author lizhiyu
 * @date 2019-12-04
 */
public class TBptMain extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 方案主键 */
    private Long bptid;

    /** 方案编码 */
    @Excel(name = "方案编码")
    private String bptCode;

    /** 方案名称 */
    @Excel(name = "方案名称")
    private String bptNm;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creator;

    /** 上传路径 */
    @Excel(name = "上传路径")
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setBptid(Long bptid)
    {
        this.bptid = bptid;
    }

    public Long getBptid() 
    {
        return bptid;
    }
    public void setBptId(String bptCode) 
    {
        this.bptCode = bptCode;
    }

    public String getBptId() 
    {
        return bptCode;
    }
    public void setBptNm(String bptNm) 
    {
        this.bptNm = bptNm;
    }

    public String getBptNm() 
    {
        return bptNm;
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
            .append("bptid", getBptid())
            .append("bptCode", getBptId())
            .append("bptNm", getBptNm())
            .append("creator", getCreator())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .append("path",getPath())
                .toString();
    }
}
