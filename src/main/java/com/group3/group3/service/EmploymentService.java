package com.group3.group3.service;

import com.group3.group3.entity.Employment;

import java.util.List;

public interface EmploymentService {

    Employment insertEmInfo(Employment employment);

    Employment deleteEmInfo(Integer emid);

    Employment updateEmInfo(Employment employment);

    List<Employment> getAllEmInfo();

    Employment getOneEmInfo(Integer uid);

    List<Employment> getPersonInfo(String username);
}
