package com.group3.group3.controller;

import com.group3.group3.entity.Result;
import com.group3.group3.entity.StudentTuition;
import com.group3.group3.entity.Tuition;
import com.group3.group3.entity.user.User;
import com.group3.group3.service.impl.StudentTuitionServiceImpl;
import com.group3.group3.service.impl.TuitionServiceImpl;
import com.group3.group3.service.impl.UserServiceImpl;
import com.group3.group3.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/studentTuition")
public class StudentTuitionController {

    @Autowired
    private StudentTuitionServiceImpl studentTuitionService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    TuitionServiceImpl tuitionService;


    @PostMapping("/insert")
    public Result insert(HttpServletRequest request,
                         @RequestParam(value = "username",required = false) String username,
                         @RequestParam(value = "schoolYear",required = false) String schoolYer,
                         @RequestParam(value = "major",required = false) String major,
                         @RequestParam(value = "handMoney",required = false) Boolean handMoney){
        Integer uid = userService.getOne(username).getUid();
        Integer tuid = tuitionService.getTuition(schoolYer,major).getTuid();
        StudentTuition studentTuition = new StudentTuition();
        studentTuition.setUid(uid);
        studentTuition.setTuid(tuid);
        studentTuition.setHandMoney(handMoney);
        studentTuitionService.insertStudentTuition(studentTuition);
        return ResultUtil.success(studentTuition);
    }

    @PostMapping("/find")
    public Result find(HttpServletRequest request,
                       @RequestParam(value = "username",required = false) String username,
                       @RequestParam(value = "schoolYear",required = false) String schoolYear,
                       @RequestParam(value = "major",required = false) String major){
        Integer uid = userService.getOne(username).getUid();
        Integer tuid= tuitionService.getTuition(schoolYear,major).getTuid();
        StudentTuition studentTuitions = studentTuitionService.getStudentTuition(uid,tuid);
        return ResultUtil.success(0,"success",studentTuitions.getHandMoney());
    }

    @GetMapping("/delete")
    public Result delete(HttpServletRequest request,
                         @RequestParam(value = "tuid",required = false) Integer tuid,
                         @RequestParam(value = "uid",required = false) Integer uid){
        studentTuitionService.deleteStudentTuition(uid,tuid);

        return ResultUtil.success(null);
    }

    @PostMapping("/update")
    public Result update(HttpServletRequest request,
                         @RequestParam(value = "username",required = false) String username,
                         @RequestParam(value = "schoolYear",required = false) String schoolYear,
                         @RequestParam(value = "major",required = false) String major,
                         @RequestParam(value = "handMoney",required = false) Boolean handMoney){
        Integer uid = userService.getOne(username).getUid();
        Integer tuid= tuitionService.getTuition(schoolYear,major).getTuid();
        StudentTuition studentTuition = studentTuitionService.getStudentTuition(uid,tuid);
        studentTuition.setHandMoney(handMoney);
        studentTuitionService.updateTuition(studentTuition);
        return ResultUtil.success(studentTuition);
    }

    @GetMapping("/findAll")
    public Result findAll(HttpServletRequest request){
        List<StudentTuition> studentTuitions = studentTuitionService.getAll();

        return ResultUtil.success(studentTuitions);
    }

}
