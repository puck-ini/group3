package com.group3.group3.controller;

import com.group3.group3.entity.Result;
import com.group3.group3.entity.Tuition;
import com.group3.group3.service.impl.TuitionServiceImpl;
import com.group3.group3.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/tuition")
public class TuitionController {

    @Autowired
    private TuitionServiceImpl tuitionService;

    @PostMapping("/insert")
    public Result insert(HttpServletRequest request,
                         @RequestParam(value = "schoolYear",required = false) String schoolYear,
                         @RequestParam(value = "major",required = false) String major,
                         @RequestParam(value = "cost",required = false) Double cost){
        Tuition tuition = new Tuition();
        tuition.setSchoolYear(schoolYear);
        tuition.setMajor(major);
        tuition.setCost(cost);
        tuitionService.insertTuition(tuition);
        return ResultUtil.success(tuition);
    }

    @GetMapping("/find")
    public Result find(HttpServletRequest request,
                             @RequestParam(value = "schoolYear",required = false) String schoolYear,
                             @RequestParam(value = "major",required = false) String major){
        Tuition tuition = tuitionService.getTuition(schoolYear,major);
        return ResultUtil.success(0,"success",tuition.getCost());
    }

    @GetMapping("/delete")
    public Result delete(HttpServletRequest request,
                       @RequestParam(value = "tuid",required = false) Integer tuid){
        tuitionService.deleteTuiTion(tuid);

        return ResultUtil.success(null);
    }

    @PostMapping("/update")
    public Result update(HttpServletRequest request,
                         @RequestParam(value = "schoolYear",required = false) String schoolYear,
                         @RequestParam(value = "major",required = false) String major,
                         @RequestParam(value = "cost",required = false) Double cost){
        Tuition tuition = tuitionService.getTuition(schoolYear,major);
        tuition.setCost(cost);
        tuitionService.updateTuition(tuition);
        return ResultUtil.success(tuition);
    }

    @GetMapping("/findAll")
    public Result findAll(HttpServletRequest request){
        List<Tuition> tuition = tuitionService.getAll();

        return ResultUtil.success(tuition);
    }
}
