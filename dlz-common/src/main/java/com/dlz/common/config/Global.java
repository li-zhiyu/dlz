package com.dlz.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 全局配置类
 * 
 * @author ruoyi
 */
@Component
@ConfigurationProperties(prefix = "dlz")
public class Global
{
    /** 项目名称 */
    private static String name;

    /** 版本 */
    private static String version;

    /** 版权年份 */
    private static String copyrightYear;

    /** 实例演示开关 */
    private static boolean demoEnabled;

    /** 上传路径 */
    private static String profile;

    /** 获取地址开关 */
    private static boolean addressEnabled;

    public static String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        Global.name = name;
    }

    public static String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        Global.version = version;
    }

    public static String getCopyrightYear()
    {
        return copyrightYear;
    }

    public void setCopyrightYear(String copyrightYear)
    {
        Global.copyrightYear = copyrightYear;
    }

    public static boolean isDemoEnabled()
    {
        return demoEnabled;
    }

    public void setDemoEnabled(boolean demoEnabled)
    {
        Global.demoEnabled = demoEnabled;
    }

    public static String getProfile()
    {
        return profile;
    }

    public void setProfile(String profile)
    {
        Global.profile = profile;
    }

    public static boolean isAddressEnabled()
    {
        return addressEnabled;
    }

    public void setAddressEnabled(boolean addressEnabled)
    {
        Global.addressEnabled = addressEnabled;
    }

    /**
     * 获取头像上传路径
     */
    public static String getAvatarPath()
    {
        return getProfile() + "/avatar";
    }
    
    /**
     * 获取节点上传路径
     */
    public static String getComponentNodePath()
    {
        return getProfile() + "/componentNode";
    }

    /**
     * 获取构件上传路径
     */
    public static String getComponentPath()
    {
        return getProfile() + "/component";
    }

    /**
     * 获取工程案例宣传图上传路径
     */
    public static String getProjectPath()
    {
        return getProfile() + "/project";
    }

    /**
     * 获取工程案例图纸模型文件上传路径
     */
    public static String getProjectFilePath()
    {
        return getProfile() + "/projectFile";
    }

    /**
     * 获取工程案例其他文件上传路径
     */
    public static String getProjectFile2Path()
    {
        return getProfile() + "/projectFile2";
    }
    
    /**
     * 获取户型上传路径
     */
    public static String getHouseTypePath()
    {
        return getProfile() + "/houseType";
    }

    /**
     * 获取Excel模板下载路径
     */
    public static String getExcelTemplatePath()
    {
        return getProfile() + "/excelTemplate";
    }

    /**
     * 获取下载路径
     */
    public static String getDownloadPath()
    {
        return getProfile() + "/download/";
    }

    /**
     * 获取上传路径
     */
    public static String getUploadPath()
    {
        return getProfile() + "/upload";
    }
}
