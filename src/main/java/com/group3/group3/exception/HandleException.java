package com.group3.group3.exception;


import com.group3.group3.enums.ExceptionEnum;

public class HandleException extends RuntimeException{
    private Integer code;

    public HandleException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
