package com.group3.group3.service.impl;

import com.group3.group3.entity.StudentActivity;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.repository.StudentActivityRepository;
import com.group3.group3.service.StudentActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuActivityServiceImpl implements StudentActivityService {
    @Autowired
    StudentActivityRepository studentActivityRepository;

    @Override
    public StudentActivity insertStuActivity(StudentActivity studentActivity) {
        veryStudentActivity(studentActivity.getUid(),studentActivity.getAcid());
        studentActivityRepository.save(studentActivity);
        return studentActivity;
    }

    @Override
    public void deleteStuActivity(Integer uid, Integer acid) {
        studentActivityRepository.deleteByUidAndAcid(uid,acid);
    }

    @Override
    public StudentActivity updateStuActivity(StudentActivity studentActivity) {
        return studentActivityRepository.save(studentActivity);
    }

    @Override
    public List<StudentActivity> getAllStuActivity() {
        return studentActivityRepository.findAll();
    }

    @Override
    public List<StudentActivity> getPersonalActivity(Integer uid) {
        List<StudentActivity> studentActivities =studentActivityRepository.findByUid(uid);
        return studentActivities;
    }

    @Override
    public StudentActivity getOne(Integer uid, Integer acid) {
        StudentActivity studentActivity = studentActivityRepository.findByUidAndAcid(uid,acid);
        return studentActivity;
    }

    private void veryStudentActivity(Integer uid,Integer acid){
        StudentActivity studentActivity = studentActivityRepository.findByUidAndAcid(uid,acid);
        if(studentActivity !=null){
            throw new HandleException(ExceptionEnum.EXIST_STUDENTACTIVITY);
        }
    }
}
