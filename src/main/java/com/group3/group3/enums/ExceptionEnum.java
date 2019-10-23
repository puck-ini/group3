package com.group3.group3.enums;

public enum ExceptionEnum {
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    UNKNOWN_FILE(123,"未找到改文件"),
    ERROR_UPLOAD(456,"上传失败"),
    ERROR_DOWNLOAD(789,"下载失败"),
    ERROR_DELETE(46666,"删除失败"),
    UNKNOWN_TYPE(666,"无发该类型文件"),
    UNKNOWN_USER(1111,"无该用户"),
    ERROR_PASSWORD(9635,"密码错误"),
    EXIST_USER(6668,"用户已存在"),
    UNKNOWN_LOGIN(4654,"未登录"),
    UNKNOWN_RESOURCE_TYPE(9999,"无该文件夹"),

    ;

    private Integer code;

    private String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
