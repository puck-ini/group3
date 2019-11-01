package com.group3.group3.controller;

import com.group3.group3.entity.Result;
import com.group3.group3.entity.StudentScholarship;
import com.group3.group3.service.impl.ScholarShipServiceImpl;
import com.group3.group3.service.impl.StudentScholarshipServiceImpl;
import com.group3.group3.service.impl.UserServiceImpl;
import com.group3.group3.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/studentScholarShip")
public class StudentScholarshipController {

    @Autowired
    private StudentScholarshipServiceImpl studentScholarshipService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ScholarShipServiceImpl scholarShipService;

    @PostMapping("/insert")
    public Result insert(HttpServletRequest request,
                         @RequestParam(value = "username",required = false) String username,
                         @RequestParam(value = "name",required = false) String name,
                         @RequestParam(value = "ssReason",required = false) String ssReason){
        Integer uid = userService.getOne(username).getUid();
        Integer ssid = scholarShipService.getScholarShip(null, name).get(0).getSsid();
        StudentScholarship studentScholarship = new StudentScholarship();
        studentScholarship.setUid(uid);
        studentScholarship.setSsid(ssid);
        studentScholarship.setSsReason(ssReason);
        studentScholarshipService.insertStuScholarship(studentScholarship);
        return ResultUtil.success(studentScholarship);
    }

    @PostMapping("/find")
    public Result find(HttpServletRequest request,
                       @RequestParam(value = "username",required = false) String username,
                       @RequestParam(value = "name",required = false) String name){
        Integer uid = userService.getOne(username).getUid();
        Integer ssid = scholarShipService.getScholarShip(null,name).get(0).getSsid();
        List<StudentScholarship> studentScholarships = studentScholarshipService.getStudentScholarship(uid,ssid);
        return ResultUtil.success(0,"success",studentScholarships.get(0).getSsReason());
    }

    @GetMapping("/delete")
    public Result delete(HttpServletRequest request,
                         @RequestParam(value = "uid",required = false) Integer uid,
                         @RequestParam(value = "ssid",required = false) Integer ssid){
        studentScholarshipService.deleteStuScholarship(uid,ssid);

        return ResultUtil.success(null);
    }

    @PostMapping("/update")
    public Result update(HttpServletRequest request,
                         @RequestParam(value = "username",required = false) String username,
                         @RequestParam(value = "name",required = false) String name,
                         @RequestParam(value = "ssReason",required = false) String ssReason){
        Integer uid = userService.getOne(username).getUid();
        Integer ssid = scholarShipService.getScholarShip(null, name).get(0).getSsid();
        List<StudentScholarship> studentScholarships = studentScholarshipService.getStudentScholarship(uid,ssid);
        StudentScholarship studentScholarship = studentScholarships.get(0);
        if (uid != null){
            studentScholarship.setUid(uid);
        }
        if (ssid != null) {
            studentScholarship.setSsid(ssid);
        }
        if (ssReason != null) {
            studentScholarship.setSsReason(ssReason);
        }
        studentScholarshipService.updateStuScholarship(studentScholarship);
        return ResultUtil.success(studentScholarship);
    }

    @GetMapping("/findAll")
    public Result findAll(HttpServletRequest request){
        List<StudentScholarship> studentScholarships = studentScholarshipService.getAll();

        return ResultUtil.success(studentScholarships);
    }
}
