package com.group3.group3.service;

import com.group3.group3.entity.StudentTuition;

import java.util.List;

public interface StudentTuitionService {
    StudentTuition getStudentTuition(Integer uid, Integer tuid);

    StudentTuition insertStudentTuition(StudentTuition studentTuition);

    void deleteStudentTuition(Integer uid,Integer tuid);

    StudentTuition updateTuition(StudentTuition studentTuition);

    List<StudentTuition> getAll();

}
