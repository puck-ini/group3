package com.group3.group3.service.impl;

import com.group3.group3.entity.Evaluation;
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
public class EvaluationServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EvaluationServiceImpl evaluationService;


    @Test
    public void insertEvInfo() {
        Evaluation evaluation = new Evaluation();
        evaluation.setComment("该老师上课认真，讲解到位。");
        evaluation.setEvgrade(95);
        evaluation.setUid(7);
        Evaluation evaluation1 = evaluationService.insertEvInfo(evaluation);
        logger.info(evaluation.toString());
    }

    @Test
    public void deleteEvInfo() {
        Integer evid = 1;
        evaluationService.deleteEvInfo(evid);
        logger.info("删除成功");
    }

    @Test
    public void getAllEvInfo() {
        List<Evaluation> evaluationList = evaluationService.getAllEvInfo();
        logger.info(evaluationList.toString());
    }

    @Test
    public void getOneEvInfo() {
        Integer uid = 4;
        List<Evaluation> evaluations = evaluationService.getOneEvInfo(uid);
        logger.info(evaluations.toString());
    }
}
