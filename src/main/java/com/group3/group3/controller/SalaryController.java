package com.group3.group3.controller;

import com.group3.group3.entity.Result;
import com.group3.group3.entity.Salary;
import com.group3.group3.entity.user.User;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.service.impl.SalaryServiceImpl;
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
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    SalaryServiceImpl salaryService;

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/insert")
    public Result insert(HttpServletRequest request,
                         @RequestParam(value = "username",required = false) String username,
                         @RequestParam(value = "salary",required = false) Double salary){
        Salary salary1 = new Salary();
        User user = userService.getOne(username);
        Integer uid = user.getUid();
        salary1.setUid(uid);
        salary1.setSalary(salary);
        salaryService.insertSalary(salary1);
        return ResultUtil.success(salary1);
    }

    @PostMapping("/find")
    public Result find(HttpServletRequest request,
                       @RequestParam(value = "username",required = false) String username){
        Integer uid = userService.getOne(username).getUid();
        if (uid !=null){
            Salary salary = salaryService.getOne(uid);
            return ResultUtil.success(0,"success",salary);
        }else {
            String username1 = null;
            try {
                Claims claims = TokenUtil.parseToken(CookieUtil.get(request, "Token").getValue());
                username1 = claims.getId();
            }catch (Exception e){
                throw new HandleException(ExceptionEnum.UNKNOWN_LOGIN);
            }
            uid = userService.getOne(username1).getUid();
            Salary salary = salaryService.getOne(uid);
            return ResultUtil.success(0,"success",salary);
        }



    }

    @GetMapping("/delete")
    public Result delete(HttpServletRequest request,
                         @RequestParam(value = "username",required = false) String username){
        User user = userService.getOne(username);
        Integer uid = user.getUid();
        salaryService.deleteSalary(uid);

        return ResultUtil.success(null);
    }

    @PostMapping("/update")
    public Result update(HttpServletRequest request,
                         @RequestParam(value = "username",required = false) String username,
                         @RequestParam(value = "salary",required = false) Double salary){
        User user = userService.getOne(username);
        Integer uid = user.getUid();
        Salary salary1 = salaryService.getOne(uid);
        if (uid != null){
            salary1.setUid(uid);
        }
        if (salary != null) {
            salary1.setSalary(salary);
        }
        salaryService.updateSalary(salary1);
        return ResultUtil.success(salary1);
    }

    @GetMapping("/findAll")
    public Result findAll(HttpServletRequest request) {
        List<Salary> salaries = salaryService.getAll();
        return ResultUtil.success(salaries);
    }
}
