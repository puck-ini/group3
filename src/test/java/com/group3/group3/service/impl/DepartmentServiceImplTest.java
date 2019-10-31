package com.group3.group3.service.impl;

import com.group3.group3.entity.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentServiceImplTest {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private DepartmentServiceImpl departmentService;


    @Test
    public void insertDepartment() {
        Department department = new Department();
        department.setDename("后勤处");
        Department department1 = departmentService.insertDepartment(department);
        log.info(department.toString());
    }

    @Test
    public void deleteDepartment() {
        Integer deid = 1;
        Department department = departmentService.deleteDepartment(deid);
    }

    @Test
    public void getAllDepartment() {
        List<Department> departmentList = departmentService.getAllDepartment();
        log.info(departmentList.toString());
    }

    @Test
    public void getOneDepatrment() {
        Integer deid = 4;
        List<Department> departmentList = departmentService.getOneDepatrment(deid);
        log.info(departmentList.toString());
    }
}
