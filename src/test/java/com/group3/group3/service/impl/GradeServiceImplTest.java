package com.group3.group3.service.impl;


import com.group3.group3.entity.Grade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GradeServiceImplTest {

    @Autowired
    private GradeServiceImpl gradeService;

    @Test
    public void insertOne() {
        Grade grade = new Grade();
        grade.setUid(3);
        grade.setCname("Java");
        grade.setGrade(95.0);
        grade.setAttendance(24);
        grade.setAbsence(3);
        grade.setUsername("sds");
        gradeService.insertOne(grade);
    }

    @Test
    public void updateOne() {
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

    @Test
    public void getOneGradeInfo() {
    }

    @Test
    public void getOne() {
    }
}
