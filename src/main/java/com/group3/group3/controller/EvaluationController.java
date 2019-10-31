package com.group3.group3.controller;

import com.group3.group3.entity.Evaluation;
import com.group3.group3.entity.Result;
import com.group3.group3.service.impl.EvaluationServiceImpl;
import com.group3.group3.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    @Autowired
    private EvaluationServiceImpl evaluationService;

    @PostMapping("/insert")
    public Result insert(HttpServletRequest request,
                         @RequestParam(value = "uid") Integer uid,
                         @RequestParam(value = "evgrade") Integer evgrade,
                         @RequestParam(value = "comment") String comment){
        Evaluation evaluation = new Evaluation();
        evaluation.setUid(uid);
        evaluation.setEvgrade(evgrade);
        evaluation.setComment(comment);
        evaluationService.insertEvInfo(evaluation);
        return ResultUtil.success(evaluation);
    }

    @GetMapping("/getAll")
    public Result getAll(){
        List<Evaluation> evaluationList = evaluationService.getAllEvInfo();
        return ResultUtil.success(evaluationList);
    }

    @GetMapping("/getOne")
    public Result getOne(HttpServletRequest request,
                         @RequestParam(value = "uid",required = false) Integer uid){
        List<Evaluation> evaluation = evaluationService.getOneEvInfo(uid);
        return ResultUtil.success(evaluation);
    }

    @GetMapping("/delete")
    public Result delete(HttpServletRequest request,
                         @RequestParam(value = "evid",required = false) Integer evid){
        evaluationService.deleteEvInfo(evid);
        return ResultUtil.success();
    }
}

