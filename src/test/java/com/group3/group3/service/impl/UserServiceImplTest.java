package com.group3.group3.service.impl;

import com.group3.group3.entity.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Test
    public void getOne() throws Exception {
        Integer id = 3;
        User user = userService.getOne(id);


    }

    @Test
    public void getOne1() throws Exception {
        String username = "sds";
        User user = userService.getOne(username);
        Integer uid = user.getUid();
        log.info(uid.toString());
        if (user == null){
            log.info("nullll");
        }else {
            log.info(user.toString());
        }

    }

    @Test
    public void getAll() throws Exception {
        List<User> list = userService.getAll();
//        List<String> stringList = new ArrayList<>();
//        stringList.add("string");
//        stringList.add("integer");
//        stringList.add("float");
//        log.info(passwordEncoder.encode("12300"));
        log.info(list.toString());
    }

    @Test
    public void insertOne() throws Exception {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("12300");
        User user1 = userService.insertOne(user);
        List<String> list = new ArrayList<>();
        Object[] objects = list.toArray();

        log.info(user.toString());

    }

    @Test
    public void updateOne() throws Exception {

        User user = userService.getOne("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        userService.updateOne(user);

    }

    @Test
    public void delete() throws Exception {
        Integer id = 2;
        User user = userService.deleteOne(id);

    }

}