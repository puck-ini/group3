package com.group3.group3.service;

import com.group3.group3.entity.StudentScholarship;

import java.util.List;

public interface StudentScholarshipService {
    List<StudentScholarship> getStudentScholarship(Integer uid,Integer ssid);

    StudentScholarship insertStuScholarship(StudentScholarship studentScholarship);

    void deleteStuScholarship(Integer uid,Integer ssid);

    StudentScholarship updateStuScholarship(StudentScholarship studentScholarship);

    List<StudentScholarship> getAll();
}
