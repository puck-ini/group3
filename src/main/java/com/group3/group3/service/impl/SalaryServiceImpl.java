package com.group3.group3.service.impl;

import com.group3.group3.entity.Salary;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.repository.SalaryRepository;
import com.group3.group3.repository.UserRepository;
import com.group3.group3.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    SalaryRepository salaryRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Salary getOne(Integer uid) {
        return salaryRepository.findByUid(uid);
    }


    @Override
    public Salary insertSalary(Salary salary) {
        verifyScholarShip(salary.getUid());
        return salaryRepository.save(salary);
    }

    @Override
    public void deleteSalary(Integer uid) {
        salaryRepository.deleteBySalaryid(uid);
    }

    @Override
    public Salary updateSalary(Salary salary) {
        return salaryRepository.save(salary);
    }

    @Override
    public List<Salary> getAll() {
        return salaryRepository.findAll();
    }

    private void verifyScholarShip(Integer uid) {
        Salary salary= salaryRepository.findByUid(uid);
        if (salary != null){
            throw new HandleException(ExceptionEnum.EXIST_SALARY);
        }
    }

}
