package com.group3.group3.service;

import com.group3.group3.entity.Course;

import java.util.List;

public interface CourseService {

    Course getOne(Integer id);

    List<Course> getAll();
}
