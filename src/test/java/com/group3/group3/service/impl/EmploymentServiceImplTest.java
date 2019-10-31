package com.group3.group3.service.impl;

import com.group3.group3.entity.Employment;
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
public class EmploymentServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EmploymentServiceImpl employmentService;


    @Test
    public void insertEmInfo() {
        Employment employment = new Employment();
        employment.setUid(5);
        employment.setJobcity("上海");
        employment.setIfgetjob(true);
        employment.setUsername("张三");
        Employment employment1 = employmentService.insertEmInfo(employment);
    }



    @Test
    public void deleteEmInfo() {
        Integer emid = 1;
        employmentService.deleteEmInfo(emid);
        logger.info("删除成功！");

    }

    @Test
    public void updateEmInfo() {

    }

    @Test
    public void getAllEmInfo() {

        List<Employment> employmentList = employmentService.getAllEmInfo();
        logger.info(employmentList.toString());
    }

    @Test
    public void getOneEmInfo() {
        Integer uid = 4;
        Employment employmentList = employmentService.getOneEmInfo(uid);
        logger.info(employmentList.toString());
    }
}
