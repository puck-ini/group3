package com.group3.group3.controller;


import com.group3.group3.entity.user.User;
import com.group3.group3.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/test")
    public String get(){

        return "test";
    }
}
