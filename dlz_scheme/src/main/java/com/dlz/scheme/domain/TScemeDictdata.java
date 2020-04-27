package com.dlz.scheme.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dlz.common.annotation.Excel;
import com.dlz.common.core.domain.BaseEntity;

/**
 * 方案与预制构件关系对象 t_sceme_dictdata
 * 
 * @author lizhiyu
 * @date 2020-04-17
 */
public class TScemeDictdata extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目ID */
    private Long faid;

    /** 数据字典ID */
    private Long dictCode;

    public void setFaid(Long faid) 
    {
        this.faid = faid;
    }

    public Long getFaid() 
    {
        return faid;
    }
    public void setDictCode(Long dictCode) 
    {
        this.dictCode = dictCode;
    }

    public Long getDictCode() 
    {
        return dictCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("faid", getFaid())
            .append("dictCode", getDictCode())
            .toString();
    }
}
