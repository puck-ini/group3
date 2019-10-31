package com.group3.group3.service.impl;

import com.group3.group3.entity.Employment;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.repository.EmploymentRepository;
import com.group3.group3.service.EmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmploymentServiceImpl implements EmploymentService {

    @Autowired
    private EmploymentRepository employmentRepository;

    @Override
    public Employment insertEmInfo(Employment employment) {
        verifyUid(employment.getUid());
        employmentRepository.save(employment);
        return employment;
    }

    private void verifyUid(Integer uid){
        List<Employment> employmentList = employmentRepository.findAllByUid(uid);
        if (employmentList.size() != 0){
            throw new HandleException(ExceptionEnum.EXIST_USER);
        }
    }

    @Override
    public Employment deleteEmInfo(Integer emid) {
        employmentRepository.deleteById(emid);
        return null;
    }

    @Override
    public Employment updateEmInfo(Employment employment) {
        return employmentRepository.save(employment);
    }

    @Override
    public List<Employment> getAllEmInfo() {
        return employmentRepository.findAll();
    }

    @Override
    public Employment getOneEmInfo(Integer uid) {
        return employmentRepository.findByUid(uid);
    }

    @Override
    public List<Employment> getPersonInfo(String username) {
        return employmentRepository.findAllByUsername(username);
    }
}
