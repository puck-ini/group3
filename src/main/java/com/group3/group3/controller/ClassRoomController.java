package com.group3.group3.controller;


import com.group3.group3.entity.ClassRoom;
import com.group3.group3.entity.Result;
import com.group3.group3.service.impl.ClassRoomServiceImpl;
import com.group3.group3.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/classRoom")
public class ClassRoomController {
    @Autowired
    private ClassRoomServiceImpl classRoomService;

    @PostMapping("/insert")
    public Result insert(HttpServletRequest request,
                         @RequestParam(value = "crname",required = false) String crname,
                         @RequestParam(value = "ifempty",required = false) Boolean ifempty){
        ClassRoom classRoom = new ClassRoom();
        classRoom.setCrname(crname);
        classRoom.setIfempty(ifempty);
        classRoomService.insertClassRoom(classRoom);
        return ResultUtil.success(classRoom);
    }

    @GetMapping("/delete")
    public Result delete(HttpServletRequest request,
                         @RequestParam(value = "crid",required = false) Integer crid){
        classRoomService.deleteClassRoom(crid);
        return ResultUtil.success();
    }

    @GetMapping("/getEmpty")
    public Result getEmpty(HttpServletRequest request,
                           @RequestParam(value = "ifempty",required = false) Boolean ifempty){
        List<ClassRoom> classRoomList = classRoomService.getEmptyRoom(ifempty);
        return  ResultUtil.success(classRoomList);
    }

    @GetMapping("/getAll")
    public Result getAll(){
        List<ClassRoom> classRooms = classRoomService.getAll();
        return ResultUtil.success(classRooms);
    }
}
