package com.group3.group3.controller;

import com.group3.group3.entity.Result;
import com.group3.group3.entity.StudentReward;
import com.group3.group3.entity.user.User;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.service.impl.RewardServiceImpl;
import com.group3.group3.service.impl.StuRewardServiceImpl;
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
@RequestMapping("studentReward")
public class StudentRewardController {

    @Autowired
    StuRewardServiceImpl stuRewardService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    RewardServiceImpl rewardService;

    @PostMapping("/insert")
    public Result insert(HttpServletRequest request,
                         @RequestParam(value = "username",required = false) String username,
                         @RequestParam(value = "reName",required = false) String reName,
                         @RequestParam(value = "reason",required = false) String reason){
        Integer uid = userService.getOne(username).getUid();
        Integer reid = rewardService.getPersonInfo(reName).get(0).getReid();
        StudentReward studentReward = new StudentReward();
        studentReward.setUid(uid);
        studentReward.setReid(reid);
        studentReward.setReason(reason);
        stuRewardService.insertStuReward(studentReward);
        return ResultUtil.success(studentReward);
    }

    @PostMapping("/delete")
    public Result delete(HttpServletRequest request,
                         @RequestParam(value = "username",required = false) String username,
                         @RequestParam(value = "reName",required = false) String reName){
        Integer uid = userService.getOne(username).getUid();
        Integer reid = rewardService.getPersonInfo(reName).get(0).getReid();
        stuRewardService.deleteStuReward(uid,reid);
        return ResultUtil.success(null);
    }

    @PostMapping("/update")
    public Result update(HttpServletRequest request,
                         @RequestParam(value = "username",required = false) String username,
                         @RequestParam(value = "reName",required = false) String reName,
                         @RequestParam(value = "reason",required = false) String reason){
        Integer uid = userService.getOne(username).getUid();
        Integer reid = rewardService.getPersonInfo(reName).get(0).getReid();
        StudentReward studentReward = new StudentReward();
        if (uid != null){
            studentReward.setUid(uid);
        }
        if (reid != null) {
            studentReward.setReid(reid);
        }
        if (reason != null) {
            studentReward.setReason(reason);
        }
       stuRewardService.updateStuReward(studentReward);
        return ResultUtil.success(studentReward);
    }

    @GetMapping("/findAll")
    public Result findAll(HttpServletRequest request){
        stuRewardService.getAllStuReward();
        return ResultUtil.success();
    }

    @PostMapping("/findPersonalReward")
    public Result findOneReward(HttpServletRequest request){
        String username = null;
        try {
            Claims claims = TokenUtil.parseToken(CookieUtil.get(request, "Token").getValue());
            username = claims.getId();
        }catch (Exception e){
            throw new HandleException(ExceptionEnum.UNKNOWN_LOGIN);
        }
        Integer uid = userService.getOne(username).getUid();
        List<StudentReward> studentRewards = stuRewardService.getPersonalReward(uid);
        return ResultUtil.success(studentRewards);

    }

    @PostMapping("/findOne")
    public Result findOne(HttpServletRequest request,
                          @RequestParam(value = "username",required = false) String username,
                          @RequestParam(value = "reName",required = false) String reName){
        Integer uid = userService.getOne(username).getUid();
        Integer reid = rewardService.getPersonInfo(reName).get(0).getReid();
        StudentReward studentReward = stuRewardService.getOne(uid,reid);
        return ResultUtil.success(studentReward);

    }
}
