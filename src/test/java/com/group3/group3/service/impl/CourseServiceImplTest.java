package com.group3.group3.service.impl;

import com.group3.group3.entity.Course;
import com.group3.group3.repository.CourseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceImplTest {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private CourseRepository repository;

    @Test
    public void getOne() throws Exception {
    }

    @Test
    public void getAll() throws Exception {



        List<Course> courseList = repository.findByCnameLike("o");

        log.info(courseList.toString());

    }

}