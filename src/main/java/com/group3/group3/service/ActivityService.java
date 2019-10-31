package com.group3.group3.service;

import com.group3.group3.entity.Activity;

import java.util.List;

public interface ActivityService {

    Activity insert(Activity activity);

    Activity delete(Integer acid);

    Activity update(Activity activity);

    List<Activity> getAll();

    List<Activity> getPersonAcInfo(String username);

    Activity getOne(String username,String name);
}
