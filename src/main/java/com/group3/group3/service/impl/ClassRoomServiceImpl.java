package com.group3.group3.service.impl;

import com.group3.group3.entity.ClassRoom;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.repository.ClassRoomRepository;
import com.group3.group3.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {


    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Override
    public ClassRoom insertClassRoom(ClassRoom classRoom) {
        verifycrname(classRoom.getCrname());
        classRoomRepository.save(classRoom);
        return classRoom;
    }

    private void verifycrname(String crname){
        List<ClassRoom> employmentList = classRoomRepository.findByCrname(crname);
        if (employmentList.size() != 0){
            throw new HandleException(ExceptionEnum.EXIST_CLASSROOM);
        }
    }

    @Override
    public ClassRoom deleteClassRoom(Integer crid) {
        classRoomRepository.deleteById(crid);
        return null;
    }

    @Override
    public List<ClassRoom> getEmptyRoom(Boolean ifempty) {
        return classRoomRepository.findAllByIfempty(ifempty);
    }

    @Override
    public List<ClassRoom> getAll() {
        return classRoomRepository.findAll();
    }
}
