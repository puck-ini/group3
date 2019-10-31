package com.group3.group3.controller;

import com.group3.group3.entity.Achievement;
import com.group3.group3.entity.Result;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.service.impl.AchievementServiceImpl;
import com.group3.group3.util.CookieUtil;
import com.group3.group3.util.ResultUtil;
import com.group3.group3.util.TokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/achievement")
public class AchievementController {

    @Autowired
    private AchievementServiceImpl achievementService;

    @PostMapping("/insert")
    public Result insert(HttpServletRequest request,
                         @RequestParam(value = "uid",required = false) Integer uid,
                         @RequestParam(value = "username",required = false) String username,
                         @RequestParam(value = "aeInformation",required = false) String aeInformation){
        Achievement achievement = new Achievement();
        achievement.setUid(uid);
        achievement.setUsername(username);
        achievement.setAeInformation(aeInformation);
        Achievement achievement1 = achievementService.insert(achievement);
        return ResultUtil.success(achievement1);
    }

    @PostMapping("/update")
    public Result update(HttpServletRequest request,
                         @RequestParam(value = "uid",required = false) Integer uid,
                         @RequestParam(value = "username",required = false) String username,
                         @RequestParam(value = "aeInformation",required = false) String aeInformation){
        Achievement achievement = achievementService.getOne(uid, aeInformation);
        achievement.setAeInformation(aeInformation);
        achievement.setUid(uid);
        if (username!=null){achievement.setUsername(username);}
        Achievement achievement1 = achievementService.update(achievement);
        return ResultUtil.success(achievement1);
    }

    @GetMapping("/delete")
    public Result delete(HttpServletRequest request,
                         @RequestParam(value = "aeid",required = false) Integer aeid){
        achievementService.delete(aeid);
        return ResultUtil.success();
    }

    @GetMapping("/getAll")
    public Result getAll(){
        List<Achievement> achievementList = achievementService.getAll();
        return ResultUtil.success(achievementList);
    }

    @GetMapping("/getPersonAcInfo")
    public Result getPeron(HttpServletRequest request){
        String username;
        try {
            Claims claims = TokenUtil.parseToken(CookieUtil.get(request, "Token").getValue());
            username = claims.getId();
        }catch (Exception e){
            throw new HandleException(ExceptionEnum.UNKNOWN_LOGIN);
        }
        List<Achievement> achievementList = achievementService.getPersonAcInfo(username);
        return ResultUtil.success(achievementList);
    }

    @GetMapping("/getOne")
    public Result getOne(HttpServletRequest request,
                         @RequestParam(value = "uid",required = false) Integer uid){
        List<Achievement> achievementList = achievementService.getSomeone(uid);
        return ResultUtil.success(achievementList);
}
}
