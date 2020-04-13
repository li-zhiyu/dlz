package com.dlz.common.enums;

public enum FileStatus {
    UPLOAD_SUCCESS("1", "上传成功"),
    CONVERT_SUCCESS("2", "转换成功"),
    CONVERT_FAIL("3", "转换失败"),
    CONVERT_PROCESSING("4", "转换中");

    private final String code;
    private final String info;

    FileStatus(String code, String info)
    {
        this.code = code;
        this.info = info;
    }

    public String getCode()
    {
        return code;
    }

    public String getInfo()
    {
        return info;
    }
}
