package com.group3.group3.service.impl;


import com.group3.group3.entity.Dormitory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DormitoryServiceImplTest {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private DormitoryServiceImpl dormitoryService;

    @Test
    public void insertDormitory() {
        Dormitory dormitory = new Dormitory();
        dormitory.setDmname("北苑-2幢-3楼-311");
        dormitory.setWater(20.0);
        dormitory.setLight(24.0);
        dormitory.setInternet(50.0);
        dormitory.setUsername("sks");
        Dormitory dormitory1 = dormitoryService.insertDormitory(dormitory);
        log.info(dormitory.toString());
    }

    @Test
    public void deleteDormitory() {
        Integer dmid = 2;
        Dormitory dormitory = dormitoryService.deleteDormitory(dmid);
        log.info("删除成功！");
    }

    @Test
    public void getAllDormitory() {
        List<Dormitory> dormitories = dormitoryService.getAllDormitory();
        log.info(dormitories.toString());
    }

    @Test
    public void getOneDormitory() {
        String username = "sds";
        List<Dormitory> dormitories = dormitoryService.getOneDormitory(username);
        log.info(dormitories.toString());
    }
}
