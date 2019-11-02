package com.group3.group3.service.impl;

import com.group3.group3.entity.Course;
import com.group3.group3.entity.user.User;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.repository.CourseRepository;
import com.group3.group3.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserServiceImpl userService;

    private Logger log = LoggerFactory.getLogger(getClass());


    @Override
    public Course getOne(Integer id) {
        Optional<Course> optional = courseRepository.findById(id);
        Course course = null;
        try {
            course = optional.get();
            log.info(course.toString());
            return course;
        }catch (Exception e){
            log.info("null");
            throw new HandleException(ExceptionEnum.UNKNOWN_COURSE);
        }
    }

    @Override
    public Course insertOne(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateOne(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course deleteOne(Integer id) {
        getOne(id);
        try {
            courseRepository.deleteById(id);
        }catch (Exception e){
            throw new HandleException(ExceptionEnum.UNKNOWN_ERROR);
        }
        return null;
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> getUserCourse(String username) {
        User user = userService.getOne(username);
        return courseRepository.findByUid(user.getUid());
    }
}
