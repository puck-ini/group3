package com.group3.group3.service;

import com.group3.group3.entity.Salary;

import java.util.List;

public interface SalaryService {

    Salary getOne(Integer uid);

    Salary insertSalary(Salary salary);

    void deleteSalary(Integer uid);

    Salary updateSalary(Salary salary);

    List<Salary> getAll();
}
