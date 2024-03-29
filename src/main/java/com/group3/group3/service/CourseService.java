package com.group3.group3.service;

import com.group3.group3.entity.Course;

import java.util.List;

public interface CourseService {

    Course getOne(Integer id);

    Course insertOne(Course course);

    Course updateOne(Course course);

    Course deleteOne(Integer id);

    List<Course> getAll();

    List<Course> getUserCourse(String username);


}
