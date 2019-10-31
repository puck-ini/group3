package com.group3.group3.repository;

import com.group3.group3.entity.Employment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmploymentRepository extends JpaRepository<Employment,Integer> {
    Employment findByUid(Integer uid);
    List<Employment> findAllByUid(Integer uid);
    List<Employment> findAllByUsername(String username);
}
