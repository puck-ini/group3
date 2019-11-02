package com.group3.group3.service.impl;

import com.group3.group3.entity.StudentReward;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.repository.StudentRewardRepository;
import com.group3.group3.service.StudentRewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuRewardServiceImpl implements StudentRewardService {

    @Autowired
    StudentRewardRepository studentRewardRepository;

    @Override
    public StudentReward insertStuReward(StudentReward studentReward) {
        verifyStuReward(studentReward.getUid(),studentReward.getReid());
        studentRewardRepository.save(studentReward);
        return studentReward;
    }

    @Override
    public void deleteStuReward(Integer uid, Integer reid) {
        studentRewardRepository.deleteByUidAndReid(uid,reid);

    }

    @Override
    public StudentReward updateStuReward(StudentReward studentReward) {
        return studentRewardRepository.save(studentReward);
    }

    @Override
    public List<StudentReward> getAllStuReward() {
        return studentRewardRepository.findAll();
    }

    @Override
    public List<StudentReward> getPersonalReward(Integer uid) {
        return studentRewardRepository.findByUid(uid);
    }

    @Override
    public StudentReward getOne(Integer uid, Integer reid) {
        return studentRewardRepository.findByUidAndReid(uid,reid);
    }

    private void verifyStuReward(Integer uid,Integer reid){
        StudentReward studentReward = studentRewardRepository.findByUidAndReid(uid,reid);
        if (studentReward != null){
            throw new HandleException(ExceptionEnum.EXIST_STUDENTREWARD);
        }
    }
}
