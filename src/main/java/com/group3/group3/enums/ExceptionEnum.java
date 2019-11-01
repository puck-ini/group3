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
    NO_EMPTY_CLASSROOM(1117,"该教室已被占用"),
    ERROR_PASSWORD(9635,"密码错误"),
    EXIST_INFO(1269,"该信息已存在"),
    EXIST_ACTIVITYINFO(8887,"用户该活动的信息已存在"),
    EXIST_RESEARCHINFO(668,"用户该科研信息已存在"),
    EXIST_USER(6668,"用户已存在"),
    EXIST_GRADE(489,"该学生本门课程的成绩已存在"),
    EXIST_DORMITORY(45,"宿舍已存在"),
    EXIST_DEPARTMENT(68,"部门已存在"),
    EXIST_CLASSROOM(66468,"教室已存在"),
    UNKNOWN_LOGIN(4654,"未登录"),
    UNKNOWN_RESOURCE_TYPE(9999,"无该文件夹"),

    EXIST_TUITION(6669,"学费已存在"),
    EXIST_STUDENTTUITION(66610,"学生的学费记录已存在"),
    EXIST_SCHOLARSHIP(66611,"该奖助贷类型已存在"),
    EXIST_STUDENTSCHOLARSHIP(66612,"该奖助贷类型已存在"),
    EXIST_SALARY(66613,"该月薪记录已存在")
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
