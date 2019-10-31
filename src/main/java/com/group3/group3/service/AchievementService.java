package com.group3.group3.service;

import com.group3.group3.entity.Achievement;

import java.util.List;

public interface AchievementService {

    Achievement insert(Achievement achievement);

    Achievement delete(Integer aeid);

    Achievement update(Achievement achievement);

    List<Achievement> getAll();

    Achievement getOne(Integer uid,String aeInformation);

    List<Achievement> getPersonAcInfo(String username);

    List<Achievement> getSomeone(Integer uid);
}
