package com.group3.group3.service.impl;

import com.group3.group3.entity.StudentInformation;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.repository.StudentInformationRepository;
import com.group3.group3.service.StudentInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInfoServiceImpl implements StudentInformationService {

    @Autowired
    StudentInformationRepository studentInformationRepository;

    @Override
    public StudentInformation insertStuInfo(StudentInformation studentInformation) {
        veryStuInfo(studentInformation.getUid());
        studentInformationRepository.save(studentInformation);
        return studentInformation;
    }

    @Override
    public void deleteStuInfo(Integer uid) {
        studentInformationRepository.deleteByUid(uid);
    }

    @Override
    public StudentInformation updateStuInfo(StudentInformation studentInformation) {
        return studentInformationRepository.save(studentInformation);
    }

    @Override
    public List<StudentInformation> getAllStuInfo() {
        List<StudentInformation> studentInformations = studentInformationRepository.findAll();
        return studentInformations;
    }

    @Override
    public StudentInformation getPersonalStuInfo(Integer uid) {
        StudentInformation studentInformation = studentInformationRepository.findByUid(uid);
        return studentInformation;
    }

    @Override
    public StudentInformation getOne(Integer uid) {
        StudentInformation studentInformation = studentInformationRepository.findByUid(uid);
        return studentInformation;
    }

    private void veryStuInfo(Integer uid){
        StudentInformation studentInformation =studentInformationRepository.findByUid(uid);
        if(studentInformation !=null){
            throw new HandleException(ExceptionEnum.EXIST_STUDENTINFO);
        }
    }
}
