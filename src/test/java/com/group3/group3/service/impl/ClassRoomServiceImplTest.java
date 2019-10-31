package com.group3.group3.service.impl;

import com.group3.group3.entity.ClassRoom;
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
public class ClassRoomServiceImplTest {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ClassRoomServiceImpl classRoomService;


    @Test
    public void insertClassRoom() throws Exception{
        ClassRoom classRoom = new ClassRoom();
        classRoom.setCrname("综合楼106");
        classRoom.setIfempty(true);
        ClassRoom classRoom1 = classRoomService.insertClassRoom(classRoom);
        log.info(classRoom.toString());
    }

    @Test
    public void deleteClassRoom() throws Exception{
        Integer crid = 1;
        classRoomService.deleteClassRoom(crid);
    }

    @Test
    public void getEmptyRoom() throws Exception{
        List<ClassRoom> classRoomList = classRoomService.getEmptyRoom(true);
        log.info(classRoomList.toString());
    }
}
