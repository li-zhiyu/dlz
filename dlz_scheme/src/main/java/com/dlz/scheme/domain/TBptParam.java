package com.dlz.scheme.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dlz.common.annotation.Excel;
import com.dlz.common.core.domain.BaseEntity;

/**
 * 方案参数对象 t_bpt_param
 * 
 * @author lizhiyu
 * @date 2019-12-06
 */
public class TBptParam extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 方案参数主键 */
    private Long bppid;

    /** 方案ID */
    @Excel(name = "方案ID")
    private String bptid;

    /** 参数名 */
    @Excel(name = "参数名")
    private String param;

    /** 参数值 */
    @Excel(name = "参数值")
    private String prmValue;
    
    
	public void setBppid(Long bppid) 
    {
        this.bppid = bppid;
    }

    public Long getBppid() 
    {
        return bppid;
    }
    public void setBptid(String bptid) 
    {
        this.bptid = bptid;
    }

    public String getBptid() 
    {
        return bptid;
    }
    public void setParam(String param) 
    {
        this.param = param;
    }

    public String getParam() 
    {
        return param;
    }
    public void setPrmValue(String prmValue) 
    {
        this.prmValue = prmValue;
    }

    public String getPrmValue() 
    {
        return prmValue;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("bppid", getBppid())
            .append("bptid", getBptid())
            .append("param", getParam())
            .append("prmValue", getPrmValue())
            .append("remark", getRemark())
            .toString();
    }
}
