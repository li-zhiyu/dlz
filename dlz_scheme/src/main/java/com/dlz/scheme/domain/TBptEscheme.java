package com.dlz.scheme.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dlz.common.annotation.Excel;
import com.dlz.common.core.domain.BaseEntity;

/**
 * 装配方案对象 t_bpt_escheme
 * 
 * @author lizhiyu
 * @date 2019-12-10
 */
public class TBptEscheme extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 装配方案主键 */
    private Long bpeid;

    /** 方案ID */
    @Excel(name = "方案ID")
    private String bptid;

    /** 装配方案名 */
    @Excel(name = "装配方案名")
    private String bpeNm;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creator;
    
    @Excel(name = "方案名称")
    private String bptNm;
       

    public String getBptNm() {
		return bptNm;
	}

	public void setBptNm(String bptNm) {
		this.bptNm = bptNm;
	}

	public void setBpeid(Long bpeid) 
    {
        this.bpeid = bpeid;
    }

    public Long getBpeid() 
    {
        return bpeid;
    }
    public void setBptid(String bptid) 
    {
        this.bptid = bptid;
    }

    public String getBptid() 
    {
        return bptid;
    }
    public void setBpeNm(String bpeNm) 
    {
        this.bpeNm = bpeNm;
    }

    public String getBpeNm() 
    {
        return bpeNm;
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
            .append("bpeid", getBpeid())
            .append("bptid", getBptid())
            .append("bpeNm", getBpeNm())
            .append("creator", getCreator())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .append("bptNm", getBptNm())
            .toString();
    }
}
