package com.dlz.scheme.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dlz.common.annotation.Excel;
import com.dlz.common.core.domain.BaseEntity;

/**
 * 方案对比数据对象 t_project_adinfo
 * 
 * @author lizhiyu
 * @date 2020-04-03
 */
public class TProjectAdinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long padid;

    /** 项目ID */
    @Excel(name = "项目ID")
    private Long pjtid;

    /** 方案ID */
    @Excel(name = "方案ID")
    private Long faid;

    /** 指标名称 */
    @Excel(name = "指标名称")
    private String zbxm;

    /** 指标编码 */
    @Excel(name = "指标编码")
    private String zbxmcode;

    /** 占比 */
    @Excel(name = "占比")
    private String zb;

    /** 得分 */
    @Excel(name = "得分")
    private String df;

    /** 备注 */
    @Excel(name = "备注")
    private String bz;

    public String getZbxmcode() {
        return zbxmcode;
    }

    public void setZbxmcode(String zbxmcode) {
        this.zbxmcode = zbxmcode;
    }

    public Long getFaid() {
        return faid;
    }

    public void setFaid(Long faid) {
        this.faid = faid;
    }

    public void setPadid(Long padid)
    {
        this.padid = padid;
    }

    public Long getPadid() 
    {
        return padid;
    }
    public void setPjtid(Long pjtid) 
    {
        this.pjtid = pjtid;
    }

    public Long getPjtid() 
    {
        return pjtid;
    }
    public void setZbxm(String zbxm) 
    {
        this.zbxm = zbxm;
    }

    public String getZbxm() 
    {
        return zbxm;
    }
    public void setZb(String zb) 
    {
        this.zb = zb;
    }

    public String getZb() 
    {
        return zb;
    }
    public void setDf(String df) 
    {
        this.df = df;
    }

    public String getDf() 
    {
        return df;
    }
    public void setBz(String bz) 
    {
        this.bz = bz;
    }

    public String getBz() 
    {
        return bz;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("padid", getPadid())
            .append("pjtid", getPjtid())
            .append("zbxm", getZbxm())
            .append("zb", getZb())
            .append("df", getDf())
            .append("bz", getBz())
            .toString();
    }
}
