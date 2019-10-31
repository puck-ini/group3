package com.group3.group3.controller;

import com.group3.group3.entity.Examination;
import com.group3.group3.entity.Result;
import com.group3.group3.service.impl.ExamnationServiceImpl;
import com.group3.group3.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/examination")
public class ExaminationController {

    @Autowired
    private ExamnationServiceImpl examnationService;

    @PostMapping("/insert")
    public Result insert(HttpServletRequest request,
                         @RequestParam(value = "uid",required = false) Integer uid,
                         @RequestParam(value = "crid",required = false) Integer crid,
                         @RequestParam(value = "exdate",required = false) String exdate) throws ParseException {
        Examination examination = new Examination();
        examination.setUid(uid);
        examination.setCrid(crid);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(exdate);
        examination.setExdate(date);
        Examination examination1 = examnationService.insertExInfo(examination);
        return ResultUtil.success(examination1);
    }

    @GetMapping("/delete")
    public Result delete(HttpServletRequest request,
                         @RequestParam(value = "exid",required = false) Integer exid){
        examnationService.deleteExInfo(exid);
        return ResultUtil.success();
    }

    @PostMapping("/update")
    public Result update(HttpServletRequest request,
                         @RequestParam(value = "crid",required = false) Integer crid,
                         @RequestParam(value = "uid",required = false) Integer uid,
                         @RequestParam(value = "exdate",required = false) String exdate) throws ParseException {
        Examination examination = examnationService.getOne(uid, crid);
        examination.setUid(uid);
        if(crid!=null){examination.setCrid(crid);}
        if(exdate!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(exdate);
            examination.setExdate(date);}
        Examination examination1 = examnationService.updateExInfo(examination);
        return ResultUtil.success(examination1);
    }

    @GetMapping("/getAll")
    public Result getAll(){
        List<Examination> examinationList = examnationService.getAllExInfo();
        return ResultUtil.success(examinationList);
    }

    @GetMapping("/getOneExInfo")
    public Result getPerson(HttpServletRequest request,
                            @RequestParam(value = "uid",required = false) Integer uid){
        List<Examination> examinations = examnationService.getOneExInfo(uid);
        return ResultUtil.success(examinations);
    }

    @GetMapping("/getOne")
    public Result getOne(HttpServletRequest request,
                         @RequestParam(value = "uid",required = false) Integer uid,
                         @RequestParam(value = "crid",required = false) Integer crid){
        Examination examination = examnationService.getOne(uid,crid);
        return ResultUtil.success(examination);
    }
}
