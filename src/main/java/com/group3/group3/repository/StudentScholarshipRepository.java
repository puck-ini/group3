package com.group3.group3.repository;

import com.group3.group3.entity.StudentScholarship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentScholarshipRepository extends JpaRepository<StudentScholarship,Integer> {
    List<StudentScholarship> findByUidAndSsid(Integer uid, Integer ssid);

    void deleteByUidAndAndSsid(Integer uid,Integer ssid);
}
