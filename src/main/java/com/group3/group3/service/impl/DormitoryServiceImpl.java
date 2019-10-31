package com.group3.group3.service.impl;

import com.group3.group3.entity.Dormitory;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.repository.DepartmentRepository;
import com.group3.group3.repository.DormitoryRepository;
import com.group3.group3.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormitoryServiceImpl implements DormitoryService {

    @Autowired
    private DormitoryRepository dormitoryRepository;

    @Override
    public Dormitory insertDormitory(Dormitory dormitory) {
        verifydmname(dormitory.getDmname(),dormitory.getUsername());
        dormitoryRepository.save(dormitory);
        return dormitory;
    }

    private void verifydmname(String dmname,String username){
        List<Dormitory> departmentList = dormitoryRepository.findAllByDmnameAndUsername(dmname,username);
        if (departmentList.size() != 0){
            throw new HandleException(ExceptionEnum.EXIST_DORMITORY);
        }
    }

    @Override
    public Dormitory deleteDormitory(Integer dmid) {
        dormitoryRepository.deleteById(dmid);
        return null;
    }

    @Override
    public List<Dormitory> getAllDormitory() {
        return dormitoryRepository.findAll();
    }

    @Override
    public List<Dormitory> getOneDormitory(String username) {
        return dormitoryRepository.findAllByUsername(username);
    }
}
