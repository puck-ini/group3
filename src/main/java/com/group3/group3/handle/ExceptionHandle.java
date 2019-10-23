package com.group3.group3.handle;

import com.group3.group3.entity.Result;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;

import com.group3.group3.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof HandleException){
            HandleException musicException = (HandleException) e;
            return ResultUtil.error(musicException.getCode(),musicException.getMessage());
        }else{
            logger.error("[系统异常]{}",e);
            return ResultUtil.error(ExceptionEnum.UNKNOWN_ERROR.getCode(),ExceptionEnum.UNKNOWN_ERROR.getMsg());
        }
    }
}
