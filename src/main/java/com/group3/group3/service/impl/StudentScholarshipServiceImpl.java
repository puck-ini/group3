package com.group3.group3.service.impl;

import com.group3.group3.entity.StudentScholarship;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.repository.StudentScholarshipRepository;
import com.group3.group3.service.StudentScholarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentScholarshipServiceImpl implements StudentScholarshipService {

    @Autowired
    StudentScholarshipRepository studentScholarshipRepository;

    @Override
    public List<StudentScholarship> getStudentScholarship(Integer uid, Integer ssid) {
        List<StudentScholarship> studentScholarships = studentScholarshipRepository.findByUidAndSsid(uid,ssid);
        return studentScholarships;
    }

    @Override
    public StudentScholarship insertStuScholarship(StudentScholarship studentScholarship) {
        verifyScholarShip(studentScholarship.getUid(),studentScholarship.getSsid());
        studentScholarshipRepository.save(studentScholarship);
        return studentScholarship;
    }

    @Override
    public void deleteStuScholarship(Integer uid, Integer ssid) {
        studentScholarshipRepository.deleteByUidAndAndSsid(uid, ssid);
    }

    @Override
    public StudentScholarship updateStuScholarship(StudentScholarship studentScholarship) {
        return studentScholarshipRepository.save(studentScholarship);
    }

    @Override
    public List<StudentScholarship> getAll() {
        return studentScholarshipRepository.findAll();
    }

    private void verifyScholarShip(Integer uid,Integer ssid) {
        List<StudentScholarship> scholarShips = studentScholarshipRepository.findByUidAndSsid(uid,ssid);
        if (scholarShips.size() != 0){
            throw new HandleException(ExceptionEnum.EXIST_STUDENTSCHOLARSHIP);
        }
    }

}
