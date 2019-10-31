package com.group3.group3.service.impl;

import com.group3.group3.entity.Activity;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.repository.ActivityRepository;
import com.group3.group3.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public Activity insert(Activity activity) {
        verifyActivity(activity.getUsername(),activity.getName());
        return activityRepository.save(activity);
    }

    private void verifyActivity(String username,String name){
        Activity activity = activityRepository.findByUsernameAndName(username, name);
        if (activity!= null){
            throw new HandleException(ExceptionEnum.EXIST_ACTIVITYINFO);
        }
    }

    @Override
    public Activity delete(Integer acid) {
         activityRepository.deleteById(acid);
        return null;
    }

    @Override
    public Activity update(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public List<Activity> getAll() {
        return activityRepository.findAll();
    }

    @Override
    public List<Activity> getPersonAcInfo(String username) {
        return activityRepository.findAllByUsername(username);
    }

    @Override
    public Activity getOne(String username, String name) {
        return activityRepository.findByUsernameAndName(username, name);
    }
}
