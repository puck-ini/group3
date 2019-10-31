package com.group3.group3.service.impl;

import com.group3.group3.entity.Department;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.repository.DepartmentRepository;
import com.group3.group3.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department insertDepartment(Department department) {
        verifydename(department.getDename());
        departmentRepository.save(department);
        return department;
    }

    private void verifydename(String dename){
        List<Department> departmentList = departmentRepository.findAllByDename(dename);
        if (departmentList.size() != 0){
            throw new HandleException(ExceptionEnum.EXIST_DEPARTMENT);
        }
    }


    @Override
    public Department deleteDepartment(Integer deid) {
        departmentRepository.deleteById(deid);
        return null;
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> getOneDepatrment(Integer deid) {
        return departmentRepository.findByDeid(deid);
    }
}
