package com.dlz.scheme.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dlz.common.annotation.Excel;
import com.dlz.common.core.domain.BaseEntity;

/**
 * 方案成本对象 t_project_costinfo
 * 
 * @author lizhiyu
 * @date 2020-04-27
 */
public class TProjectCostinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long pciid;

    /** 方案ID */
    @Excel(name = "方案ID")
    private Long faid;

    /** 指标名称 */
    @Excel(name = "指标名称")
    private String costItem;

    /** 指标编码 */
    @Excel(name = "指标编码")
    private String costItemCode;

    /** 含量 */
    @Excel(name = "含量")
    private String content;

    /** 单价 */
    @Excel(name = "单价")
    private String price;

    /** 变化 */
    @Excel(name = "变化")
    private String change;

    public void setPciid(Long pciid) 
    {
        this.pciid = pciid;
    }

    public Long getPciid() 
    {
        return pciid;
    }
    public void setFaid(Long faid) 
    {
        this.faid = faid;
    }

    public Long getFaid() 
    {
        return faid;
    }
    public void setCostItem(String costItem) 
    {
        this.costItem = costItem;
    }

    public String getCostItem() 
    {
        return costItem;
    }
    public void setCostItemCode(String costItemCode) 
    {
        this.costItemCode = costItemCode;
    }

    public String getCostItemCode() 
    {
        return costItemCode;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setPrice(String price) 
    {
        this.price = price;
    }

    public String getPrice() 
    {
        return price;
    }
    public void setChange(String change) 
    {
        this.change = change;
    }

    public String getChange() 
    {
        return change;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pciid", getPciid())
            .append("faid", getFaid())
            .append("costItem", getCostItem())
            .append("costItemCode", getCostItemCode())
            .append("content", getContent())
            .append("price", getPrice())
            .append("change", getChange())
            .toString();
    }
}
