package com.dlz.scheme.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dlz.common.annotation.Excel;
import com.dlz.common.core.domain.BaseEntity;

/**
 * 方案明细对象 t_bpt_detail
 * 
 * @author lizhiyu
 * @date 2019-12-04
 */
public class TBptDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 方案明细主键 */
    private Long bpdid;

    /** 方案ID */
    @Excel(name = "方案ID")
    private String bptid;

    /** 明细 */
    @Excel(name = "明细")
    private String detail;

    /** 明细值 */
    @Excel(name = "明细值")
    private String detailValue;

    public void setBpdid(Long bpdid) 
    {
        this.bpdid = bpdid;
    }

    public Long getBpdid() 
    {
        return bpdid;
    }
    public void setBptid(String bptid) 
    {
        this.bptid = bptid;
    }

    public String getBptid() 
    {
        return bptid;
    }
    public void setDetail(String detail) 
    {
        this.detail = detail;
    }

    public String getDetail() 
    {
        return detail;
    }
    public void setDetailValue(String detailValue) 
    {
        this.detailValue = detailValue;
    }

    public String getDetailValue() 
    {
        return detailValue;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("bpdid", getBpdid())
            .append("bptid", getBptid())
            .append("detail", getDetail())
            .append("detailValue", getDetailValue())
            .append("remark", getRemark())
            .toString();
    }
}
