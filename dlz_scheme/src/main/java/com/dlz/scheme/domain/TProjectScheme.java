package com.dlz.scheme.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dlz.common.annotation.Excel;
import com.dlz.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 方案管理对象 t_project_scheme
 * 
 * @author lizhiyu
 * @date 2020-04-16
 */
public class TProjectScheme extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 方案主键 */
    private Long faid;

    /** 项目ID */
    @Excel(name = "项目ID")
    private String pjtid;

    /** 方案名称 */
    @Excel(name = "方案名称")
    private String famc;

    /** 是否为默认方案 */
    @Excel(name = "是否为默认方案")
    private String isDefault;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creator;

    /** 预制构件 */
    @Excel(name = "创建人")
    private Long[] yzcomponentsIds;

    private TProjectInfo projectInfo;

    private List<TProjectAdinfo> projectAdinfos;

    public TProjectInfo getProjectInfo() {
        return projectInfo;
    }

    public void setProjectInfo(TProjectInfo projectInfo) {
        this.projectInfo = projectInfo;
    }

    public Long[] getYzcomponentsIds() {
        return yzcomponentsIds;
    }

    public void setYzcomponentsIds(Long[] yzcomponentsIds) {
        this.yzcomponentsIds = yzcomponentsIds;
    }

    public void setFaid(Long faid)
    {
        this.faid = faid;
    }

    public Long getFaid() 
    {
        return faid;
    }
    public void setPjtid(String pjtid) 
    {
        this.pjtid = pjtid;
    }

    public String getPjtid() 
    {
        return pjtid;
    }
    public void setFamc(String famc) 
    {
        this.famc = famc;
    }

    public String getFamc() 
    {
        return famc;
    }
    public void setIsDefault(String isDefault) 
    {
        this.isDefault = isDefault;
    }

    public String getIsDefault() 
    {
        return isDefault;
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
            .append("faid", getFaid())
            .append("pjtid", getPjtid())
            .append("famc", getFamc())
            .append("isDefault", getIsDefault())
            .append("creator", getCreator())
            .append("createTime", getCreateTime())
            .toString();
    }
}
