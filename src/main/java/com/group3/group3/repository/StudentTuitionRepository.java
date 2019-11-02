package com.group3.group3.repository;

import com.group3.group3.entity.StudentTuition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentTuitionRepository extends JpaRepository<StudentTuition,Integer> {
    StudentTuition findByUidAndTuid(Integer uid,Integer tuid);

    void deleteByUidAndTuid(Integer uid,Integer tuid);

}
