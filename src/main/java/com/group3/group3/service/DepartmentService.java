package com.group3.group3.service;


import com.group3.group3.entity.Department;

import java.util.List;

public interface DepartmentService {

    Department insertDepartment(Department department);

    Department deleteDepartment(Integer deid);

    List<Department> getAllDepartment();

    List<Department> getOneDepatrment(Integer deid);

}
