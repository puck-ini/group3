package com.group3.group3.repository;

import com.group3.group3.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaryRepository extends JpaRepository<Salary,Integer> {

    Salary findByUid(Integer uid);

    void deleteBySalaryid(Integer uid);
}
