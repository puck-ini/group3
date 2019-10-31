package com.group3.group3.service.impl;


import com.group3.group3.entity.Examination;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ExaminationServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ExamnationServiceImpl examinationService;


    @Test
    public void insertExInfo() throws ParseException {
        Examination examination = new Examination();
        examination.setCrid(3);
        examination.setUid(2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse("2019-05-19 09:34:11");
        examination.setExdate(date);
        examinationService.insertExInfo(examination);
        logger.info(examination.toString());
    }

    @Test
    public void deleteExInfo() {
        Integer exid = 1;
        examinationService.deleteExInfo(exid);
        logger.info("删除成功");
    }

    @Test
    public void updateExInfo() {
    }

    @Test
    public void getAllExInfo() {
        List<Examination> list = examinationService.getAllExInfo();
        logger.info(list.toString());
    }

    @Test
    public void getOneExInfo() {
        Integer uid = 2;
        List<Examination> list = examinationService.getOneExInfo(uid);
        logger.info(list.toString());
    }
}
