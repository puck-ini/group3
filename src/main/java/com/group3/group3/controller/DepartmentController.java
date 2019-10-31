package com.group3.group3.controller;


import com.group3.group3.entity.Department;
import com.group3.group3.entity.Result;
import com.group3.group3.service.impl.DepartmentServiceImpl;
import com.group3.group3.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @PostMapping("/insert")
    public Result insert(HttpServletRequest request,
                         @RequestParam(value = "dename") String dename){
        Department department = new Department();
        department.setDename(dename);
        departmentService.insertDepartment(department);
        return ResultUtil.success(department);
    }

    @GetMapping("/getAll")
    public Result getAll(){
        List<Department> departmentList = departmentService.getAllDepartment();
        return ResultUtil.success(departmentList);
    }

    @GetMapping("/getOneDepartment")
    public Result getOne(HttpServletRequest request,
                         @RequestParam(value = "deid",required = false) Integer deid){
        List<Department> department = departmentService.getOneDepatrment(deid);
        return ResultUtil.success(department);
    }

    @GetMapping("/delete")
    public Result delete(HttpServletRequest request,
                         @RequestParam(value = "deid",required = false) Integer deid){
        departmentService.deleteDepartment(deid);
        return ResultUtil.success();
    }
}

