package com.group3.group3.service;

import com.group3.group3.entity.StudentReward;

import java.util.List;

public interface StudentRewardService {
    StudentReward insertStuReward(StudentReward studentReward);

    void deleteStuReward(Integer uid,Integer reid);

    StudentReward updateStuReward(StudentReward studentReward);

    List<StudentReward> getAllStuReward();

    List<StudentReward> getPersonalReward(Integer uid);

    StudentReward getOne(Integer uid,Integer reid);
}
