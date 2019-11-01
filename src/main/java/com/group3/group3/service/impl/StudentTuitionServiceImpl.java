package com.group3.group3.service.impl;

import com.group3.group3.entity.StudentTuition;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.repository.StudentTuitionRepository;
import com.group3.group3.service.StudentTuitionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentTuitionServiceImpl implements StudentTuitionService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentTuitionRepository studentTuitionRepository;

    @Override
    public StudentTuition getStudentTuition(Integer uid,Integer tuid) {
        return studentTuitionRepository.findByUidAndTuid(uid,tuid);
    }

    @Override
    public StudentTuition insertStudentTuition(StudentTuition studentTuition) {
        verifyTuiton(studentTuition.getUid(),studentTuition.getTuid());
        studentTuitionRepository.save(studentTuition);
        return studentTuition;
    }

    @Override
    public void deleteStudentTuition(Integer uid, Integer tuid) {
        studentTuitionRepository.deleteByUidAndTuid(uid,tuid);
    }

    @Override
    public StudentTuition updateTuition(StudentTuition studentTuition) {
        return studentTuitionRepository.save(studentTuition);
    }

    @Override
    public List<StudentTuition> getAll() {
        return studentTuitionRepository.findAll();
    }

    private void verifyTuiton(Integer uid,Integer tuid){
        StudentTuition studentTuition = studentTuitionRepository.findByUidAndTuid(uid,tuid);
        if (studentTuition!= null){
            throw new HandleException(ExceptionEnum.EXIST_STUDENTTUITION);
        }
    }
}
