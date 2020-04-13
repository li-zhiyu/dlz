package com.dlz.scheme.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dlz.common.annotation.Excel;
import com.dlz.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 t_project_info
 * 
 * @author lizhiyu
 * @date 2020-03-23
 */
public class TProjectInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目主键 */
    @Excel(name = "项目主键")
    private String pjtid;

    /** 项目名 */
    @Excel(name = "项目名")
    private String pjtNm;

    /** 项目地址 */
    @Excel(name = "项目地址")
    private String pjtAddress;

    /** 省ID */
    @Excel(name = "省ID")
    private String provinceId;

    /** 省 */
    @Excel(name = "省")
    private String province;

    /** 市ID */
    @Excel(name = "市ID")
    private String cityId;

    /** 市 */
    @Excel(name = "市")
    private String city;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creator;

    /** 成本增量 */
    @Excel(name = "成本增量")
    private String cbzl;

    /** 建筑户型 */
    @Excel(name = "建筑户型")
    private String jzhx;

    /** 核心筒 */
    @Excel(name = "核心筒")
    private String hxt;

    /** 预制构件 */
    @Excel(name = "预制构件")
    private String yzgj;

    /** 机电集成 */
    @Excel(name = "机电集成")
    private String jdjc;

    /** 开发商 */
    @Excel(name = "开发商")
    private String kfs;

    /** 层高 */
    @Excel(name = "层高")
    private String cg;

    /** 单层建筑面积 */
    @Excel(name = "单层建筑面积")
    private String dcjzmj;

    /** 地上建筑层数 */
    @Excel(name = "地上建筑层数")
    private String dsjzcs;

    /** 结构体系 */
    @Excel(name = "结构体系")
    private String jgtx;

    /** 地上建筑高度 */
    @Excel(name = "地上建筑高度")
    private String dsjzgd;

    /** 装配率要求 */
    @Excel(name = "装配率要求")
    private String zplyq;

    /** 户型数 */
    @Excel(name = "户型数")
    private String hxs;

    /** 户型1 */
    @Excel(name = "户型1")
    private String hx1;

    /** 户型1 */
    @Excel(name = "户型1")
    private String hx2;

    /** 户型3 */
    @Excel(name = "户型3")
    private String hx3;

    /** 户型4 */
    @Excel(name = "户型4")
    private String hx4;

    /** 缩略图文件路径 */
    @Excel(name = "缩略图文件路径")
    private String tblPath;

    /** 文件上传路径 */
    @Excel(name = "文件上传路径")
    private String path;

    public void setPjtid(String pjtid) 
    {
        this.pjtid = pjtid;
    }

    public String getPjtid() 
    {
        return pjtid;
    }
    public void setPjtNm(String pjtNm) 
    {
        this.pjtNm = pjtNm;
    }

    public String getPjtNm() 
    {
        return pjtNm;
    }
    public void setPjtAddress(String pjtAddress) 
    {
        this.pjtAddress = pjtAddress;
    }

    public String getPjtAddress() 
    {
        return pjtAddress;
    }
    public void setProvinceId(String provinceId) 
    {
        this.provinceId = provinceId;
    }

    public String getProvinceId() 
    {
        return provinceId;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCityId(String cityId) 
    {
        this.cityId = cityId;
    }

    public String getCityId() 
    {
        return cityId;
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
    public void setCbzl(String cbzl) 
    {
        this.cbzl = cbzl;
    }

    public String getCbzl() 
    {
        return cbzl;
    }
    public void setJzhx(String jzhx) 
    {
        this.jzhx = jzhx;
    }

    public String getJzhx() 
    {
        return jzhx;
    }
    public void setHxt(String hxt) 
    {
        this.hxt = hxt;
    }

    public String getHxt() 
    {
        return hxt;
    }
    public void setYzgj(String yzgj) 
    {
        this.yzgj = yzgj;
    }

    public String getYzgj() 
    {
        return yzgj;
    }
    public void setJdjc(String jdjc) 
    {
        this.jdjc = jdjc;
    }

    public String getJdjc() 
    {
        return jdjc;
    }
    public void setKfs(String kfs) 
    {
        this.kfs = kfs;
    }

    public String getKfs() 
    {
        return kfs;
    }
    public void setCg(String cg) 
    {
        this.cg = cg;
    }

    public String getCg() 
    {
        return cg;
    }
    public void setDcjzmj(String dcjzmj) 
    {
        this.dcjzmj = dcjzmj;
    }

    public String getDcjzmj() 
    {
        return dcjzmj;
    }
    public void setDsjzcs(String dsjzcs) 
    {
        this.dsjzcs = dsjzcs;
    }

    public String getDsjzcs() 
    {
        return dsjzcs;
    }
    public void setJgtx(String jgtx) 
    {
        this.jgtx = jgtx;
    }

    public String getJgtx() 
    {
        return jgtx;
    }
    public void setDsjzgd(String dsjzgd) 
    {
        this.dsjzgd = dsjzgd;
    }

    public String getDsjzgd() 
    {
        return dsjzgd;
    }
    public void setZplyq(String zplyq) 
    {
        this.zplyq = zplyq;
    }

    public String getZplyq() 
    {
        return zplyq;
    }
    public void setHxs(String hxs) 
    {
        this.hxs = hxs;
    }

    public String getHxs() 
    {
        return hxs;
    }
    public void setHx1(String hx1) 
    {
        this.hx1 = hx1;
    }

    public String getHx1() 
    {
        return hx1;
    }
    public void setHx2(String hx2) 
    {
        this.hx2 = hx2;
    }

    public String getHx2() 
    {
        return hx2;
    }
    public void setHx3(String hx3) 
    {
        this.hx3 = hx3;
    }

    public String getHx3() 
    {
        return hx3;
    }
    public void setHx4(String hx4) 
    {
        this.hx4 = hx4;
    }

    public String getHx4() 
    {
        return hx4;
    }
    public void setTblPath(String tblPath) 
    {
        this.tblPath = tblPath;
    }

    public String getTblPath() 
    {
        return tblPath;
    }
    public void setPath(String path) 
    {
        this.path = path;
    }

    public String getPath() 
    {
        return path;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pjtid", getPjtid())
            .append("pjtNm", getPjtNm())
            .append("pjtAddress", getPjtAddress())
            .append("provinceId", getProvinceId())
            .append("province", getProvince())
            .append("cityId", getCityId())
            .append("city", getCity())
            .append("createTime", getCreateTime())
            .append("creator", getCreator())
            .append("remark", getRemark())
            .append("cbzl", getCbzl())
            .append("jzhx", getJzhx())
            .append("hxt", getHxt())
            .append("yzgj", getYzgj())
            .append("jdjc", getJdjc())
            .append("kfs", getKfs())
            .append("cg", getCg())
            .append("dcjzmj", getDcjzmj())
            .append("dsjzcs", getDsjzcs())
            .append("jgtx", getJgtx())
            .append("dsjzgd", getDsjzgd())
            .append("zplyq", getZplyq())
            .append("hxs", getHxs())
            .append("hx1", getHx1())
            .append("hx2", getHx2())
            .append("hx3", getHx3())
            .append("hx4", getHx4())
            .append("tblPath", getTblPath())
            .append("path", getPath())
            .toString();
    }
}
