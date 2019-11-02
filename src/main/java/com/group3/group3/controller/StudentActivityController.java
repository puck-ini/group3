package com.group3.group3.controller;

import com.group3.group3.entity.Result;
import com.group3.group3.entity.StudentActivity;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.service.impl.ActivityServiceImpl;
import com.group3.group3.service.impl.StuActivityServiceImpl;
import com.group3.group3.service.impl.UserServiceImpl;
import com.group3.group3.util.CookieUtil;
import com.group3.group3.util.ResultUtil;
import com.group3.group3.util.TokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/studentActivity")
public class StudentActivityController {

    @Autowired
    StuActivityServiceImpl stuActivityService;

    @Autowired
    ActivityServiceImpl activityService;

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/insert")
    public Result insert(HttpServletRequest request,
                         @RequestParam(value = "username",required = false) String username,
                         @RequestParam(value = "name",required = false) String name,
                         @RequestParam(value = "acInformation",required = false) String acInformation){
        Integer uid = userService.getOne(username).getUid();
        Integer acid = activityService.getOne(username,name).getAcid();
        StudentActivity studentActivity = new StudentActivity();
        studentActivity.setUid(uid);
        studentActivity.setAcid(acid);
        studentActivity.setAcInformation(acInformation);
        stuActivityService.insertStuActivity(studentActivity);
        return ResultUtil.success(studentActivity);
    }


    @GetMapping("/delete")
    public Result delete(HttpServletRequest request,
                         @RequestParam(value = "uid",required = false) Integer uid,
                         @RequestParam(value = "acid",required = false) Integer acid){
        stuActivityService.deleteStuActivity(uid, acid);
        return ResultUtil.success();
    }

    @PostMapping("/update")
    public Result update(HttpServletRequest request,
                         @RequestParam(value = "username",required = false) String username,
                         @RequestParam(value = "name",required = false) String name,
                         @RequestParam(value = "acInformation",required = false) String acInformation){
        Integer uid = userService.getOne(username).getUid();
        Integer acid = activityService.getOne(username,name).getAcid();
        StudentActivity studentActivity = new StudentActivity();
        if (uid != null){
            studentActivity.setUid(uid);
        }
        if (acid != null) {
            studentActivity.setAcid(acid);
        }
        if (acInformation != null) {
            studentActivity.setAcInformation(acInformation);
        }
        stuActivityService.updateStuActivity(studentActivity);
        return ResultUtil.success(studentActivity);
    }

    @GetMapping("/findAll")
    public Result findAll(HttpServletRequest request){
        List<StudentActivity> studentActivities = stuActivityService.getAllStuActivity();
        return ResultUtil.success(studentActivities);
    }

    @GetMapping("/findPersonal")
    public Result findPersonal(HttpServletRequest request){
        String username = null;
        try {
            Claims claims = TokenUtil.parseToken(CookieUtil.get(request, "Token").getValue());
            username = claims.getId();
        }catch (Exception e){
            throw new HandleException(ExceptionEnum.UNKNOWN_LOGIN);
        }
        Integer uid = userService.getOne(username).getUid();
        List<StudentActivity> studentActivities = stuActivityService.getPersonalActivity(uid);
        return ResultUtil.success(studentActivities);
    }

    @GetMapping("/findOne")
    public Result findOne(HttpServletRequest request,
                          @RequestParam(value = "username",required = false) String username,
                          @RequestParam(value = "name",required = false) String name){
        Integer uid = userService.getOne(username).getUid();
        Integer acid = activityService.getOne(username,name).getAcid();
        StudentActivity studentActivitiy = stuActivityService.getOne(uid,acid);
        return ResultUtil.success(studentActivitiy);
    }
}
