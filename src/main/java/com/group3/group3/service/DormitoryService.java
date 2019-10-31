package com.group3.group3.service;

import com.group3.group3.entity.Dormitory;

import java.util.List;

public interface DormitoryService {

    Dormitory insertDormitory(Dormitory dormitory);

    Dormitory deleteDormitory(Integer dmid);

    List<Dormitory> getAllDormitory();

    List<Dormitory> getOneDormitory(String username);
}
