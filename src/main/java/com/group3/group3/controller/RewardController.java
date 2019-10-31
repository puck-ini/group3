package com.group3.group3.controller;

import com.group3.group3.entity.Result;
import com.group3.group3.entity.Reward;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.service.impl.RewardServiceImpl;
import com.group3.group3.util.CookieUtil;
import com.group3.group3.util.ResultUtil;
import com.group3.group3.util.TokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reward")
public class RewardController {

    @Autowired
    private RewardServiceImpl rewardService;

    @PostMapping("/insert")
    public Result insert(HttpServletRequest request,
                         @RequestParam(value = "reName",required = false) String reName,
                         @RequestParam(value = "date",required = false) String date,
                         @RequestParam(value = "reType",required = false) String reType) throws ParseException {
        Reward reward = new Reward();
        reward.setReName(reName);
        reward.setReType(reType);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse(date);
        reward.setDate(date1);
        Reward reward1 = rewardService.insert(reward);
        return ResultUtil.success(reward1);
    }

    @GetMapping("/delete")
    public Result delete(HttpServletRequest request,
                         @RequestParam(value = "reid",required = false) Integer reid){
        rewardService.delete(reid);
        return ResultUtil.success();
    }

    @GetMapping("/getAll")
    public Result getAll(){
        List<Reward> rewardList = rewardService.getAll();
        return ResultUtil.success(rewardList);
    }

    @GetMapping("/getPersonReward")
    public Result getOne(HttpServletRequest request){
        String username;
        try {
            Claims claims = TokenUtil.parseToken(CookieUtil.get(request, "Token").getValue());
            username = claims.getId();
        }catch (Exception e){
            throw new HandleException(ExceptionEnum.UNKNOWN_LOGIN);
        }
        List<Reward> reward = rewardService.getPersonInfo(username);
        return ResultUtil.success(reward);
    }
}
