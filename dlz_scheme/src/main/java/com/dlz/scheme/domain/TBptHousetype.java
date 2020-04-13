package com.dlz.scheme.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dlz.common.annotation.Excel;
import com.dlz.common.core.domain.BaseEntity;

/**
 * 户型对象 t_bpt_housetype
 * 
 * @author lizhiyu
 * @date 2019-12-16
 */
public class TBptHousetype extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 户型主键 */
    private Long htid;

    /** 户型名 */
    @Excel(name = "户型名")
    private String htNm;

    /** 户型编码 */
    @Excel(name = "户型编码")
    private String htNo;

    /** 类型 */
    @Excel(name = "类型")
    private String htType;

    /** 文件名 */
    @Excel(name = "文件名")
    private String fileNm;

    /** 文件上传路径 */
    @Excel(name = "文件上传路径")
    private String path;

    /** 备注 */
    @Excel(name = "备注")
    private String memo;

    /** 所在地 */
    @Excel(name = "所在地")
    private String address;

    /** 开发商 */
    @Excel(name = "开发商")
    private String kfs;

    /** 户型数 */
    @Excel(name = "户型数")
    private String hxs;

    /** 户型一 */
    @Excel(name = "户型一")
    private String hx1;

    /** 户型二 */
    @Excel(name = "户型二")
    private String hx2;

    /** 户型三 */
    @Excel(name = "户型三")
    private String hx3;

    /** 户型四 */
    @Excel(name = "户型四")
    private String hx4;

    /** 单层建筑面积 */
    @Excel(name = "单层建筑面积")
    private String dcjzmj;

    /** 层高 */
    @Excel(name = "层高")
    private String cg;


    public void setHtid(Long htid) 
    {
        this.htid = htid;
    }

    public Long getHtid() 
    {
        return htid;
    }
    public void setHtNm(String htNm) 
    {
        this.htNm = htNm;
    }

    public String getHtNm() 
    {
        return htNm;
    }
    public void setHtNo(String htNo) 
    {
        this.htNo = htNo;
    }

    public String getHtNo() 
    {
        return htNo;
    }
    public void setHtType(String htType) 
    {
        this.htType = htType;
    }

    public String getHtType() 
    {
        return htType;
    }
    public void setFileNm(String fileNm) 
    {
        this.fileNm = fileNm;
    }

    public String getFileNm() 
    {
        return fileNm;
    }
    public void setPath(String path) 
    {
        this.path = path;
    }

    public String getPath() 
    {
        return path;
    }
    public void setMemo(String memo) 
    {
        this.memo = memo;
    }

    public String getMemo() 
    {
        return memo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getKfs() {
        return kfs;
    }

    public void setKfs(String kfs) {
        this.kfs = kfs;
    }

    public String getHxs() {
        return hxs;
    }

    public void setHxs(String hxs) {
        this.hxs = hxs;
    }

    public String getHx1() {
        return hx1;
    }

    public void setHx1(String hx1) {
        this.hx1 = hx1;
    }

    public String getHx2() {
        return hx2;
    }

    public void setHx2(String hx2) {
        this.hx2 = hx2;
    }

    public String getHx3() {
        return hx3;
    }

    public void setHx3(String hx3) {
        this.hx3 = hx3;
    }

    public String getHx4() {
        return hx4;
    }

    public void setHx4(String hx4) {
        this.hx4 = hx4;
    }

    public String getDcjzmj() {
        return dcjzmj;
    }

    public void setDcjzmj(String dcjzmj) {
        this.dcjzmj = dcjzmj;
    }

    public String getCg() {
        return cg;
    }

    public void setCg(String cg) {
        this.cg = cg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("htid", getHtid())
            .append("htNm", getHtNm())
            .append("htNo", getHtNo())
            .append("htType", getHtType())
            .append("fileNm", getFileNm())
            .append("path", getPath())
            .append("memo", getMemo())
            .append("address", getAddress())
            .append("kfs", getKfs())
            .append("hxs", getHxs())
            .append("hx1", getHx1())
            .append("hx2", getHx2())
            .append("hx3", getHx3())
            .append("hx4", getHx4())
            .append("dcjzmj", getDcjzmj())
            .append("cg", getCg())
            .toString();
    }
}
