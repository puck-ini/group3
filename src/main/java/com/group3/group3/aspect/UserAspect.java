package com.group3.group3.aspect;


import com.group3.group3.entity.user.User;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.service.impl.UserServiceImpl;
import com.group3.group3.util.CookieUtil;
import com.group3.group3.util.TokenUtil;
import io.jsonwebtoken.Claims;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class UserAspect {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private UserServiceImpl userService;

    //TODO
    //@Pointcut("execution(public * com.group3.group3.controller.*.*(..))")
    public void verify(){}


    //@Before("verify()")
    public void doVerify(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String username;
        try {
            Claims claims = TokenUtil.parseToken(CookieUtil.get(request, "Token").getValue());
            username = claims.getId();
        }catch (Exception e){
            throw new HandleException(ExceptionEnum.UNKNOWN_LOGIN);
        }
        User user = userService.getOne(username);

        //TODO

        if (!antPathMatcher.match("","")){
            throw new HandleException(ExceptionEnum.UNKNOWN_ROLE);
        }
    }
}
