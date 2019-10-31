package com.group3.group3.controller;

import com.group3.group3.entity.Research;
import com.group3.group3.entity.Result;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.service.impl.ResearchServiceImpl;
import com.group3.group3.util.CookieUtil;
import com.group3.group3.util.ResultUtil;
import com.group3.group3.util.TokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/research")
public class ResearchController {

    @Autowired
    private ResearchServiceImpl researchService;

    @PostMapping("/insert")
    public Result insert(HttpServletRequest request,
                         @RequestParam(value = "uid",required = false) Integer uid,
                         @RequestParam(value = "username",required = true) String username,
                         @RequestParam(value = "researchName",required = false) String researchName,
                         @RequestParam(value = "researchInformation",required = false) String researchInformation){
        Research research = new Research();
        research.setUid(uid);
        research.setUsername(username);
        research.setResearchName(researchName);
        research.setResearchInformation(researchInformation);
        Research research1 = researchService.insertOne(research);
        return ResultUtil.success(research1);
    }

    @PostMapping("/update")
    public Result update(HttpServletRequest request,
                         @RequestParam(value = "uid",required = true) Integer uid,
                         @RequestParam(value = "researchName",required = true) String researchName,
                         @RequestParam(value = "researchInformation",required = true) String researchInformation){
        Research research = researchService.getOne(uid, researchName);
        research.setUid(uid);
        research.setResearchName(researchName);
        if(researchInformation!=null){
            research.setResearchInformation(researchInformation);
        }
        Research research1 = researchService.updateOne(research);
        return ResultUtil.success(research1);
    }

    @GetMapping("/getAll")
    public Result getAll(HttpServletRequest request){
        List<Research> researchList = researchService.getAllReInfo();
        return ResultUtil.success(researchList);
    }

    @GetMapping("/getPersonReInfo")
    public Result getPerson(HttpServletRequest request){
        String username;
        try {
            Claims claims = TokenUtil.parseToken(CookieUtil.get(request, "Token").getValue());
            username = claims.getId();
        }catch (Exception e){
            throw new HandleException(ExceptionEnum.UNKNOWN_LOGIN);
        }
        List<Research> researchList = researchService.getPersonInfo(username);
        return ResultUtil.success(researchList);
    }

    @GetMapping("/getOneReInfo")
    public Result getOne(HttpServletRequest request,
                         @RequestParam(value = "researchName",required = false) String researchName){
        List<Research> researchList = researchService.getOneReAllInfo(researchName);
        return ResultUtil.success(researchList);
    }

    @GetMapping("/delete")
    public Result delete(HttpServletRequest request,
                         @RequestParam(value = "researchid",required = true) Integer researchid){
        researchService.deleteOne(researchid);
        return ResultUtil.success();
    }
}
