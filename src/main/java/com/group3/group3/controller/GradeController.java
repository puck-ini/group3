package com.group3.group3.controller;

import com.group3.group3.entity.Grade;
import com.group3.group3.entity.Result;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.service.impl.GradeServiceImpl;
import com.group3.group3.util.CookieUtil;
import com.group3.group3.util.ResultUtil;
import com.group3.group3.util.TokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeServiceImpl gradeService;

    @PostMapping("/insert")
    public Result insert(HttpServletRequest request,
                         @RequestParam(value = "cname",required = false) String cname,
                         @RequestParam(value = "uid",required = false) Integer uid,
                         @RequestParam(value = "username",required = false) String username,
                         @RequestParam(value = "grade",required = false) Double grade,
                         @RequestParam(value = "attendance",required = false) Integer attendance,
                         @RequestParam(value = "absence",required = false) Integer absence){
        Grade grade1 = new Grade();
        grade1.setCname(cname);
        grade1.setUid(uid);
        grade1.setUsername(username);
        grade1.setGrade(grade);
        grade1.setAttendance(attendance);
        grade1.setAbsence(absence);
        Grade grade2 = gradeService.insertOne(grade1);
        return ResultUtil.success(grade2);
    }

    @GetMapping("/delete")
    public Result delete(HttpServletRequest request,
                         @RequestParam(value = "gid",required = false) Integer gid){
        gradeService.delete(gid);
        return ResultUtil.success();
    }

    @PostMapping("/update")
    public Result update(HttpServletRequest request,
                         @RequestParam(value = "cname",required = false) String cname,
                         @RequestParam(value = "uid",required = false) Integer uid,
                         @RequestParam(value = "grade",required = false) Double grade,
                         @RequestParam(value = "attendance",required = false) Integer attendance,
                         @RequestParam(value = "absence",required = false) Integer absence){
        Grade grade1 = gradeService.getOne(uid, cname);
        grade1.setUid(uid);
        grade1.setCname(cname);
        if(grade!=null){grade1.setGrade(grade);}
        if(attendance!=null){grade1.setAttendance(attendance);}
        if(absence!=null){grade1.setAbsence(absence);}
        Grade grade2 = gradeService.updateOne(grade1);
        return ResultUtil.success(grade2);
    }

    @GetMapping("/getAll")
    public Result getAll(HttpServletRequest request){
        List<Grade> gradeList = gradeService.getAll();
        return ResultUtil.success(gradeList);
    }

    @GetMapping("/getPersonGrade")
    public Result getPerson(HttpServletRequest request){
        String username;
        try {
            Claims claims = TokenUtil.parseToken(CookieUtil.get(request, "Token").getValue());
            username = claims.getId();
        }catch (Exception e){
            throw new HandleException(ExceptionEnum.UNKNOWN_LOGIN);
        }
        List<Grade> grades = gradeService.getPersonInfo(username);
        return ResultUtil.success(grades);
    }

    @GetMapping("/getOneGradeInfo")
    public Result getOneGradeInfo(HttpServletRequest request,
                                  @RequestParam(value = "cname",required = false) String cname){
        List<Grade> gradeList = gradeService.getOneGradeInfo(cname);
        return ResultUtil.success(gradeList);
    }
}
