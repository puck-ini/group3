package com.group3.group3.controller;



import com.group3.group3.entity.Result;
import com.group3.group3.entity.user.User;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.service.impl.CardServiceImpl;
import com.group3.group3.service.impl.UserServiceImpl;
import com.group3.group3.util.CookieUtil;
import com.group3.group3.util.ResultUtil;
import com.group3.group3.util.TokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserServiceImpl userService;
    public CardServiceImpl cardService;





    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/login")
    public Result login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletResponse response){
        User user = userService.getOne(username);
        if (!passwordEncoder.matches(password,user.getPassword())){
            throw new HandleException(ExceptionEnum.ERROR_PASSWORD);
        }
        String token = TokenUtil.createToken(user.getUsername(),"132",10000*60*60*10);
        CookieUtil.set(response,"Token",token,60000);

        return ResultUtil.success(0,"成功",token);
    }

    @GetMapping("/signout")
    public Result signOut(HttpServletResponse response,HttpServletRequest request){
        Cookie cookie = CookieUtil.get(request,"Token");
        if (cookie != null){
            CookieUtil.set(response,"Token",null,0);
        }
        return ResultUtil.success(0,"登出",null);
    }

    @PostMapping("/recompose")
    public Result recompose(HttpServletRequest request,
                            @RequestParam("oldPassword") String oldPassword,
                            @RequestParam("newPassword") String newPassword){
        String username = null;
        try {
            Claims claims = TokenUtil.parseToken(CookieUtil.get(request, "Token").getValue());
            username = claims.getId();
        }catch (Exception e){
            throw new HandleException(ExceptionEnum.UNKNOWN_LOGIN);
        }
        User user = userService.getOne(username);
        if (!passwordEncoder.matches(oldPassword,user.getPassword())){
            throw new HandleException(ExceptionEnum.ERROR_PASSWORD);
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        User user1 = userService.updateOne(user);
        return ResultUtil.success(user1);
    }

    @PostMapping("/updateinfo")
    public Result updateInfo(HttpServletRequest request,
                             @RequestParam(value = "name",required = false) String name,
                             @RequestParam(value = "gender",required = false) String gender,
                             @RequestParam(value = "telephone",required = false) String telephone,
                             @RequestParam(value = "politics",required = false) String politics,
                             @RequestParam(value = "type",required = false) String type){
        String username = null;
        try {
            Claims claims = TokenUtil.parseToken(CookieUtil.get(request, "Token").getValue());
            username = claims.getId();
        }catch (Exception e){
            throw new HandleException(ExceptionEnum.UNKNOWN_LOGIN);
        }
        User user = userService.getOne(username);
        if (name != null){
            user.setName(name);
        }
        if(gender != null){
            user.setGender(gender);
        }
        if (telephone != null){
            user.setTelephone(telephone);
        }
        if (politics != null){
            user.setPolitics(politics);
        }
        if (type != null){
            user.setType(type);
        }
        User user1 = userService.updateOne(user);

        return ResultUtil.success(user1);
    }

    @GetMapping("/getInfo")
    public Result getInfo(HttpServletRequest request){
        String username;
        try {
            Claims claims = TokenUtil.parseToken(CookieUtil.get(request, "Token").getValue());
            username = claims.getId();
        }catch (Exception e){
            throw new HandleException(ExceptionEnum.UNKNOWN_LOGIN);
        }
        User user = userService.getOne(username);
        return ResultUtil.success(user);
    }

    @GetMapping("/delete")
    public Result delete(HttpServletRequest request){
        String username = null;
        try {
            Claims claims = TokenUtil.parseToken(CookieUtil.get(request, "Token").getValue());
            username = claims.getId();
        }catch (Exception e){
            throw new HandleException(ExceptionEnum.UNKNOWN_LOGIN);
        }
        User user = userService.getOne(username);
        userService.deleteOne(user.getUid());
        return ResultUtil.success();
    }

    

    @GetMapping("/getAllUser")
    public Result getAllUser(){
        List<User> users = userService.getAll();
        return ResultUtil.success(users);
    }





}
