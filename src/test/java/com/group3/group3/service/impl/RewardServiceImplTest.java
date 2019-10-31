package com.group3.group3.service.impl;

import com.group3.group3.entity.Reward;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RewardServiceImplTest {

    @Autowired
    private RewardServiceImpl rewardService;


    @Test
    public void insert() throws ParseException {
        Reward reward = new Reward();
        reward.setReName("李四");
        reward.setReType("喝酒");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2019-08-09");
        reward.setDate(date);
        rewardService.insert(reward);
    }

    @Test
    public void delete() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void getPersonInfo() {
    }
}
