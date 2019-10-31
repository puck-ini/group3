package com.group3.group3.controller;


import com.group3.group3.entity.Dormitory;
import com.group3.group3.entity.Result;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.service.impl.DormitoryServiceImpl;
import com.group3.group3.util.CookieUtil;
import com.group3.group3.util.ResultUtil;
import com.group3.group3.util.TokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/dormitory")
public class DormitoryController {

    @Autowired
    private DormitoryServiceImpl dormitoryService;

    @PostMapping("/insert")
    public Result insert(HttpServletRequest request,
                         @RequestParam(value = "dmname") String dmname,
                         @RequestParam(value = "light") Double light,
                         @RequestParam(value = "username") String username,
                         @RequestParam(value = "water") Double water,
                         @RequestParam(value = "internet") Double internet){
        Dormitory dormitory = new Dormitory();
        dormitory.setDmname(dmname);
        dormitory.setUsername(username);
        dormitory.setInternet(internet);
        dormitory.setLight(light);
        dormitory.setWater(water);
        dormitoryService.insertDormitory(dormitory);
        return ResultUtil.success(dormitory);
    }

    @GetMapping("/getAll")
    public Result getAll(){
        List<Dormitory> dormitoryList = dormitoryService.getAllDormitory();
        return ResultUtil.success(dormitoryList);
    }

    @GetMapping("/getOneDormitory")
    public Result getOne(HttpServletRequest request){
        String username;
        try {
            Claims claims = TokenUtil.parseToken(CookieUtil.get(request, "Token").getValue());
            username = claims.getId();
        }catch (Exception e){
            throw new HandleException(ExceptionEnum.UNKNOWN_LOGIN);
        }
        List<Dormitory> dormitorieList = dormitoryService.getOneDormitory(username);
        return ResultUtil.success(dormitorieList);
    }

    @GetMapping("/delete")
    public Result delete(HttpServletRequest request,
                         @RequestParam(value = "dmid",required = false) Integer dmid){
        dormitoryService.deleteDormitory(dmid);
        return ResultUtil.success();
    }
}

