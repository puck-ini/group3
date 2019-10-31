package com.group3.group3.controller;


import com.group3.group3.entity.Employment;
import com.group3.group3.entity.Result;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.service.impl.EmploymentServiceImpl;
import com.group3.group3.util.CookieUtil;
import com.group3.group3.util.ResultUtil;
import com.group3.group3.util.TokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/employment")
public class EmploymentController {

    @Autowired
    private EmploymentServiceImpl employmentService;
    @PostMapping("/insert")
    public Result insert(HttpServletRequest request,
                         @RequestParam(value = "uid",required = false) Integer uid,
                         @RequestParam(value = "username",required = false) String username,
                         @RequestParam(value = "ifgetjob",required = false) Boolean ifgetjob,
                         @RequestParam(value = "jobcity",required = false) String jobcity){
        Employment employment = new Employment();
        employment.setUid(uid);
        employment.setUsername(username);
        employment.setIfgetjob(ifgetjob);
        employment.setJobcity(jobcity);
        employmentService.insertEmInfo(employment);
        return ResultUtil.success(employment);
    }

    @PostMapping("/update")
    public Result update(HttpServletRequest request,
                         @RequestParam(value = "uid",required = false) Integer uid,
                         @RequestParam(value = "ifgetjob",required = false) Boolean ifgetjob,
                         @RequestParam(value = "jobcity",required = false) String jobcity){
        Employment employment = employmentService.getOneEmInfo(uid);
        employment.setUid(uid);
        if(ifgetjob!=null){
            employment.setIfgetjob(ifgetjob);
        }
        if(jobcity!=null){
            employment.setJobcity(jobcity);
        }
        Employment employment1 = employmentService.updateEmInfo(employment);
        return ResultUtil.success(employment1);
    }

    @GetMapping("/getAll")
    public Result getAll(){
        List<Employment> employments = employmentService.getAllEmInfo();
        return ResultUtil.success(employments);
    }

    @GetMapping("/getOne")
    public Result getOne(HttpServletRequest request,
                         @RequestParam(value = "uid",required = false) Integer uid){
        Employment employment = employmentService.getOneEmInfo(uid);
        return ResultUtil.success(employment);
    }

    @GetMapping("/getPerson")
    public Result getPerson(HttpServletRequest request){
        String username;
        try {
            Claims claims = TokenUtil.parseToken(CookieUtil.get(request, "Token").getValue());
            username = claims.getId();
        }catch (Exception e){
            throw new HandleException(ExceptionEnum.UNKNOWN_LOGIN);
        }
        List<Employment> employmentList = employmentService.getPersonInfo(username);
        return ResultUtil.success(employmentList);
    }

    @GetMapping("/delete")
    public Result delete(HttpServletRequest request,
                         @RequestParam(value = "emid",required = false) Integer emid){
        employmentService.deleteEmInfo(emid);
        return ResultUtil.success();
    }


}

