package com.group3.group3.repository;

import com.group3.group3.entity.StudentActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentActivityRepository extends JpaRepository<StudentActivity,Integer> {
    StudentActivity findByUidAndAcid(Integer uid, Integer acid);

    void deleteByUidAndAcid(Integer uid, Integer acid);

    List<StudentActivity> findByUid(Integer uid);
}
