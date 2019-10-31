package com.group3.group3.service.impl;

import com.group3.group3.entity.Achievement;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.repository.AchievementRepository;
import com.group3.group3.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementServiceImpl implements AchievementService {

    @Autowired
    private AchievementRepository achievementRepository;

    @Override
    public Achievement insert(Achievement achievement) {
        verifyExit(achievement.getUid(),achievement.getAeInformation());
        achievementRepository.save(achievement);
        return achievement;
    }

    private void verifyExit(Integer uid,String aeInformation){
        Achievement achievement = achievementRepository.findByUidAndAeInformation(uid, aeInformation);
        if (achievement!= null){
            throw new HandleException(ExceptionEnum.EXIST_INFO);
        }
    }

    @Override
    public Achievement delete(Integer aeid) {
        achievementRepository.deleteById(aeid);
        return null;
    }

    @Override
    public Achievement update(Achievement achievement) {
        return achievementRepository.save(achievement);
    }

    @Override
    public List<Achievement> getAll() {
        return achievementRepository.findAll();
    }

    @Override
    public Achievement getOne(Integer uid, String aeInformation) {
        return achievementRepository.findByUidAndAeInformation(uid, aeInformation);
    }

    @Override
    public List<Achievement> getPersonAcInfo(String username) {
        return achievementRepository.findAllByUsername(username);
    }

    @Override
    public List<Achievement> getSomeone(Integer uid) {
        return achievementRepository.findAllByUid(uid);
    }
}
