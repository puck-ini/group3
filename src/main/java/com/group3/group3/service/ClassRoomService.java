package com.group3.group3.service;


import com.group3.group3.entity.ClassRoom;

import java.util.List;

public interface ClassRoomService {

    ClassRoom insertClassRoom(ClassRoom classRoom);

    ClassRoom deleteClassRoom(Integer crid);

    List<ClassRoom> getEmptyRoom(Boolean ifempty);

    List<ClassRoom> getAll();
}
