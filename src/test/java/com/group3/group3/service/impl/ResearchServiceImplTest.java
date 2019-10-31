package com.group3.group3.service.impl;

import com.group3.group3.entity.Research;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ResearchServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ResearchServiceImpl researchService;


    @Test
    public void insertOne() {
        Research research = new Research();
        research.setUid(5);
        research.setResearchName("人工智能");
        research.setResearchInformation("人工智能（Artificial Intelligence），英文缩写为AI。它是研究、开发用于模拟、延伸和扩展人的智能的理论、方法、技术及应用系统的一门新的技术科学。");
        researchService.insertOne(research);
    }

    @Test
    public void updateOne() {
    }

    @Test
    public void deleteOne() {
    }

    @Test
    public void getAllReInfo() {
    }

    @Test
    public void getPersonInfo() {
    }

    @Test
    public void getOneReAllInfo() {
    }
}
