package com.group3.group3.service;

import com.group3.group3.entity.StudentInformation;

import java.util.List;

public interface StudentInformationService {
    StudentInformation insertStuInfo(StudentInformation studentInformation);

    void deleteStuInfo(Integer uid);

    StudentInformation updateStuInfo(StudentInformation studentInformation);

    List<StudentInformation> getAllStuInfo();

    StudentInformation getPersonalStuInfo(Integer uid);

    StudentInformation getOne(Integer uid);
}
