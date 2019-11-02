package com.group3.group3.repository;

import com.group3.group3.entity.StudentReward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRewardRepository extends JpaRepository<StudentReward,Integer> {

    StudentReward findByUidAndReid(Integer uid, Integer reid);

    void deleteByUidAndReid(Integer uid, Integer reid);

    List<StudentReward> findByUid(Integer uid);
}
