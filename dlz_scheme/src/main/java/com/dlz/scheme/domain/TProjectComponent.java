package com.dlz.scheme.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dlz.common.annotation.Excel;
import com.dlz.common.core.domain.BaseEntity;

/**
 * 项目-构件关系表对象 t_project_component
 * 
 * @author lizhiyu
 * @date 2020-03-31
 */
public class TProjectComponent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目ID */
    private Long pjtid;

    /** 构件ID */
    private Long cpid;

    public void setPjtid(Long pjtid) 
    {
        this.pjtid = pjtid;
    }

    public Long getPjtid() 
    {
        return pjtid;
    }
    public void setCpid(Long cpid) 
    {
        this.cpid = cpid;
    }

    public Long getCpid() 
    {
        return cpid;
    }

    public TProjectComponent(Long pjtid, Long cpid) {
        this.pjtid = pjtid;
        this.cpid = cpid;
    }

    public TProjectComponent() {
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pjtid", getPjtid())
            .append("cpid", getCpid())
            .toString();
    }
}
