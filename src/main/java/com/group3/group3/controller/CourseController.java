package com.group3.group3.controller;


import com.group3.group3.entity.Course;
import com.group3.group3.entity.Result;
import com.group3.group3.entity.user.User;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.service.impl.CourseServiceImpl;
import com.group3.group3.service.impl.UserServiceImpl;
import com.group3.group3.util.CookieUtil;
import com.group3.group3.util.ResultUtil;
import com.group3.group3.util.TokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseServiceImpl courseService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/getall")
    public Result getAll(){
        return ResultUtil.success(courseService.getAll());
    }

    @PostMapping("/get")
    public Result getCourse(@RequestParam("id") String id){
        Integer cid = Integer.valueOf(id);
        Course course = courseService.getOne(cid);

        return ResultUtil.success(course);
    }


    @PostMapping("/insert")
    public Result insertCourse(HttpServletRequest request,
                               @RequestParam("cname") String cname,
                               @RequestParam("csyear") String csyear,
                               @RequestParam("semester") String semester,
                               @RequestParam("ctype") String ctype,
                               @RequestParam("classdate") String classdate,
                               @RequestParam("classplace") String classplace){
        String username = null;
        try {
            Claims claims = TokenUtil.parseToken(CookieUtil.get(request, "Token").getValue());
            username = claims.getId();
        }catch (Exception e){
            throw new HandleException(ExceptionEnum.UNKNOWN_LOGIN);
        }
        User user = userService.getOne(username);
        Course course = new Course();
        course.setUid(user.getUid());
        course.setCname(cname);
        course.setCsyear(csyear);
        course.setSemester(semester);
        course.setCtype(ctype);
        course.setClassdate(classdate);
        course.setClassplace(classplace);
        return ResultUtil.success(courseService.insertOne(course));
    }

    @PostMapping("/update")
    public Result updateCourse(HttpServletRequest request,
                               @RequestParam("cname") String cname,
                               @RequestParam("csyear") String csyear,
                               @RequestParam("semester") String semester,
                               @RequestParam("ctype") String ctype,
                               @RequestParam("classdate") String classdate,
                               @RequestParam("classplace") String classplace){
        String username = null;
        try {
            Claims claims = TokenUtil.parseToken(CookieUtil.get(request, "Token").getValue());
            username = claims.getId();
        }catch (Exception e){
            throw new HandleException(ExceptionEnum.UNKNOWN_LOGIN);
        }
        Course course = new Course();
        course.setCname(cname);
        course.setCsyear(csyear);
        course.setSemester(semester);
        course.setCtype(ctype);
        course.setClassdate(classdate);
        course.setClassplace(classplace);
        return ResultUtil.success(courseService.insertOne(course));
    }


    @GetMapping("/delete")
    public Result deleteCourse(HttpServletRequest request,
                               @RequestParam("id") Integer cid){
        courseService.deleteOne(cid);
        return ResultUtil.success();
    }

    @GetMapping("/teach/course")
    public Result teachCourse(HttpServletRequest request){
        String username = null;
        try {
            Claims claims = TokenUtil.parseToken(CookieUtil.get(request, "Token").getValue());
            username = claims.getId();
        }catch (Exception e){
            throw new HandleException(ExceptionEnum.UNKNOWN_LOGIN);
        }
        return ResultUtil.success(courseService.getUserCourse(username));
    }
}
