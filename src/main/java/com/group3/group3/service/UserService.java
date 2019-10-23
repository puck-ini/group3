package com.group3.group3.service;

import com.group3.group3.entity.user.User;

import java.util.List;


public interface UserService {

    User getOne(Integer id);

    User getOne(String username);


    List<User> getAll();

    User insertOne(User user);

    User updateOne(User user);

    void deleteOne(Integer id);
}
