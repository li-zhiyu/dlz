package com.dlz.scheme.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dlz.common.annotation.Excel;
import com.dlz.common.core.domain.BaseEntity;

/**
 * 政策文件对象 t_politic_document
 * 
 * @author lizhiyu
 * @date 2020-05-05
 */
public class TPoliticDocument extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long pdid;

    /** 政策文件名 */
    @Excel(name = "政策文件名")
    private String pdNm;

    /** 文件地址 */
    @Excel(name = "文件地址")
    private String path;

    /** 省份 */
    @Excel(name = "省份")
    private String province;

    /** 市 */
    @Excel(name = "市")
    private String city;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creator;

    /** 备注 */
    @Excel(name = "备注")
    private String memo;

    public void setPdid(Long pdid) 
    {
        this.pdid = pdid;
    }

    public Long getPdid() 
    {
        return pdid;
    }
    public void setPdNm(String pdNm) 
    {
        this.pdNm = pdNm;
    }

    public String getPdNm() 
    {
        return pdNm;
    }
    public void setPath(String path) 
    {
        this.path = path;
    }

    public String getPath() 
    {
        return path;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }
    public void setMemo(String memo) 
    {
        this.memo = memo;
    }

    public String getMemo() 
    {
        return memo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pdid", getPdid())
            .append("pdNm", getPdNm())
            .append("path", getPath())
            .append("province", getProvince())
            .append("city", getCity())
            .append("creator", getCreator())
            .append("createTime", getCreateTime())
            .append("memo", getMemo())
            .toString();
    }
}
