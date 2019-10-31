package com.group3.group3.repository;

import com.group3.group3.entity.Dormitory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DormitoryRepository extends JpaRepository<Dormitory,Integer> {

    List<Dormitory> findAllByDmnameAndUsername(String dmname,String username);
    List<Dormitory> findAllByUsername(String username);
}
