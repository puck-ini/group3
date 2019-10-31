package com.group3.group3.repository;

import com.group3.group3.entity.ClassRoom;
import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClassRoomRepository extends JpaRepository<ClassRoom,Integer> {
    List<ClassRoom> findAllByIfempty(Boolean ifempty);
    List<ClassRoom> findByCrname(String crname);
    List<ClassRoom> findByCridAndIfempty(Integer crid,Boolean ifempty);



}
