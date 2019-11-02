package com.group3.group3.service;

import com.group3.group3.entity.StudentActivity;

import java.util.List;

public interface StudentActivityService {
    StudentActivity insertStuActivity(StudentActivity studentActivity);

    void deleteStuActivity(Integer uid,Integer acid);

    StudentActivity updateStuActivity(StudentActivity studentActivity);

    List<StudentActivity> getAllStuActivity();

    List<StudentActivity> getPersonalActivity(Integer uid);

    StudentActivity getOne(Integer uid,Integer acid);
}
