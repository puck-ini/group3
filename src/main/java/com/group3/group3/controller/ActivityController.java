package com.group3.group3.controller;

import com.group3.group3.entity.Activity;
import com.group3.group3.entity.Result;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.service.impl.ActivityServiceImpl;
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
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityServiceImpl activityService;

    @PostMapping("/insert")
    public Result insert(HttpServletRequest request,
                         @RequestParam(value = "name",required = false) String name,
                         @RequestParam(value = "username",required = false) String username,
                         @RequestParam(value = "type",required = false) String type,
                         @RequestParam(value = "place",required = false) String place,
                         @RequestParam(value = "acDate",required = false) String acDate) throws ParseException {
        Activity activity = new Activity();
        activity.setName(name);
        activity.setUsername(username);
        activity.setType(type);
        activity.setPlace(place);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(acDate);
        activity.setAcDate(date);
        Activity activity1 = activityService.insert(activity);
        return ResultUtil.success(activity1);
    }

    @PostMapping("/update")
    public Result update(HttpServletRequest request,
                         @RequestParam(value = "name",required = false) String name,
                         @RequestParam(value = "username",required = false) String username,
                         @RequestParam(value = "type",required = false) String type,
                         @RequestParam(value = "place",required = false) String place,
                         @RequestParam(value = "acDate",required = false) String acDate) throws ParseException{
        Activity activity = activityService.getOne(username, name);
        activity.setUsername(username);
        activity.setName(name);
        if (type!=null){activity.setType(type);}
        if (place!=null){activity.setPlace(place);}
        if (acDate!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(acDate);
            activity.setAcDate(date);}
        Activity activity1 = activityService.update(activity);
        return ResultUtil.success(activity1);
    }

    @GetMapping("/delete")
    public Result delete(HttpServletRequest request,
                         @RequestParam(value = "acid",required = false) Integer acid){
        activityService.delete(acid);
        return ResultUtil.success();
    }

    @GetMapping("/getAll")
    public Result getAll(){
        List<Activity> activityList = activityService.getAll();
        return ResultUtil.success(activityList);
    }

    @GetMapping("/getPersonActivity")
    public Result getOne(HttpServletRequest request){
        String username;
        try {
            Claims claims = TokenUtil.parseToken(CookieUtil.get(request, "Token").getValue());
            username = claims.getId();
        }catch (Exception e){
            throw new HandleException(ExceptionEnum.UNKNOWN_LOGIN);
        }
        List<Activity> activityList = activityService.getPersonAcInfo(username);
        return ResultUtil.success(activityList);
    }
}
