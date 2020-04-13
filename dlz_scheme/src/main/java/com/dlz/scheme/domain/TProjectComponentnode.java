package com.dlz.scheme.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dlz.common.annotation.Excel;
import com.dlz.common.core.domain.BaseEntity;

/**
 * 项目-节点关系绑定对象 t_project_componentnode
 * 
 * @author lizhiyu
 * @date 2020-04-01
 */
public class TProjectComponentnode extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目ID */
    private Long pjtid;

    /** 节点ID */
    private Long cnid;

    public TProjectComponentnode(Long pjtid, Long cnid) {
        this.pjtid = pjtid;
        this.cnid = cnid;
    }

    public TProjectComponentnode() {
    }

    public void setPjtid(Long pjtid)
    {
        this.pjtid = pjtid;
    }

    public Long getPjtid() 
    {
        return pjtid;
    }
    public void setCnid(Long cnid) 
    {
        this.cnid = cnid;
    }

    public Long getCnid() 
    {
        return cnid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pjtid", getPjtid())
            .append("cnid", getCnid())
            .toString();
    }
}
