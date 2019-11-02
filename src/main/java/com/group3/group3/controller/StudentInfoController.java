package com.group3.group3.controller;


import com.group3.group3.entity.Result;
import com.group3.group3.entity.StudentInformation;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.service.impl.StudentInfoServiceImpl;
import com.group3.group3.service.impl.UserServiceImpl;
import com.group3.group3.util.CookieUtil;
import com.group3.group3.util.ResultUtil;
import com.group3.group3.util.TokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/studentInfo")
public class StudentInfoController {

    @Autowired
    StudentInfoServiceImpl studentInfoService;

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/insert")
    public Result insert(HttpServletRequest request,
                         @RequestParam(value = "username",required = false) String username,
                         @RequestParam(value = "name",required = false) String name,
                         @RequestParam(value = "gender",required = false) String gender,
                         @RequestParam(value = "bornDate",required = false) Date bornDate,
                         @RequestParam(value = "school",required = false) String school,
                         @RequestParam(value = "source",required = false) String source,
                         @RequestParam(value = "leaveSchool",required = false) String leaveSchool,
                         @RequestParam(value = "education",required = false) String education,
                         @RequestParam(value = "major",required = false) String major,
                         @RequestParam(value = "enterDate",required = false) Date enterDate,
                         @RequestParam(value = "leaveDate",required = false) Date leaveDate){
        StudentInformation studentInformation = new StudentInformation();
        Integer uid = userService.getOne(username).getUid();
        studentInformation.setUid(uid);
        studentInformation.setUsername(username);
        studentInformation.setGender(gender);
        studentInformation.setBornDate(bornDate);
        studentInformation.setSchool(school);
        studentInformation.setSource(source);
        studentInformation.setLeaveSchool(leaveSchool);
        studentInformation.setEducation(education);
        studentInformation.setMajor(major);
        studentInformation.setEnterDate(enterDate);
        studentInformation.setLeaveDate(leaveDate);
        studentInfoService.insertStuInfo(studentInformation);
        return ResultUtil.success(studentInformation);
    }

    @GetMapping("/delete")
    public Result delete(HttpServletRequest request,
                         @RequestParam(value = "uid",required = false) Integer uid){
        studentInfoService.deleteStuInfo(uid);
        return ResultUtil.success();

    }

    @PostMapping("/update")
    public Result update(HttpServletRequest request,
                         @RequestParam(value = "username",required = false) String username,
                         @RequestParam(value = "name",required = false) String name,
                         @RequestParam(value = "gender",required = false) String gender,
                         @RequestParam(value = "bornDate",required = false) Date bornDate,
                         @RequestParam(value = "school",required = false) String school,
                         @RequestParam(value = "source",required = false) String source,
                         @RequestParam(value = "leaveSchool",required = false) String leaveSchool,
                         @RequestParam(value = "education",required = false) String education,
                         @RequestParam(value = "major",required = false) String major,
                         @RequestParam(value = "enterDate",required = false) Date enterDate,
                         @RequestParam(value = "leaveDate",required = false) Date leaveDate){
        Integer uid= userService.getOne(username).getUid();
        StudentInformation studentInformation = studentInfoService.getOne(uid);
        if (uid != null){
            studentInformation.setUid(uid);
        }
        if (username != null) {
            studentInformation.setUsername(username);
        }
        if (gender != null) {
            studentInformation.setGender(gender);
        }
        if (bornDate != null) {
            studentInformation.setBornDate(bornDate);
        }
        if (school != null) {
            studentInformation.setSchool(school);
        }if (source != null) {
            studentInformation.setSource(source);
        }if (leaveSchool != null) {
            studentInformation.setLeaveSchool(leaveSchool);
        }if (education != null) {
            studentInformation.setEducation(education);
        }
        if (major != null) {
            studentInformation.setMajor(major);
        }if (enterDate != null) {
            studentInformation.setEnterDate(enterDate);
        }if (leaveDate != null) {
            studentInformation.setLeaveDate(leaveDate);
        }

        studentInfoService.updateStuInfo(studentInformation);
        return ResultUtil.success(studentInformation);
    }

    @GetMapping("/findAll")
    public Result findAll(HttpServletRequest request){
        studentInfoService.getAllStuInfo();
        return ResultUtil.success();
    }

    @PostMapping("/findPersonalInfo")
    public Result findPersonalInfo(HttpServletRequest request){
        String username = null;
        try {
            Claims claims = TokenUtil.parseToken(CookieUtil.get(request, "Token").getValue());
            username = claims.getId();
        }catch (Exception e){
            throw new HandleException(ExceptionEnum.UNKNOWN_LOGIN);
        }
        Integer uid = userService.getOne(username).getUid();
        studentInfoService.getPersonalStuInfo(uid);
        return ResultUtil.success();
    }

    @PostMapping("/findOneInfo")
    public Result findOneInfo(HttpServletRequest request,
                                   @RequestParam(value = "username",required = false) String username){
        Integer uid = userService.getOne(username).getUid();
        studentInfoService.getOne(uid);
        return ResultUtil.success();
    }
}
