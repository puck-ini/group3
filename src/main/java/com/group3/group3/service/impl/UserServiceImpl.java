package com.group3.group3.service.impl;

import com.group3.group3.entity.StudentInformation;
import com.group3.group3.entity.user.User;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.repository.StudentInfoRepository;
import com.group3.group3.repository.UserRepository;
import com.group3.group3.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentInfoRepository studentInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User getOne(Integer id) {
        Optional<User> optional = userRepository.findById(id);
        User user = null;
        try {
            user = optional.get();
            log.info(user.toString());
            return user;
        }catch (Exception e){
            log.info("null");
            throw new HandleException(ExceptionEnum.UNKNOWN_USER);
        }
    }

    @Override
    public User getOne(String username) {
        List<User> userList = userRepository.findByUsername(username);
        if (userList.size() == 0){
            throw new HandleException(ExceptionEnum.UNKNOWN_USER);
        }
        User user = userList.get(0);
        return user;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public User insertOne(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        verifyUsername(user.getUsername());
        User user1 = userRepository.save(user);
        StudentInformation studentInformation = new StudentInformation();
        studentInformation.setUid(user1.getUid());
        studentInformation.setUsername(user1.getUsername());
        studentInformation.setGender(user1.getGender());
        studentInfoRepository.save(studentInformation);
        return user;
    }

    private void verifyUsername(String username){
        List<User> userList = userRepository.findByUsername(username);
        if (userList.size() != 0){
            throw new HandleException(ExceptionEnum.EXIST_USER);
        }
    }

    @Override
    public User updateOne(User user) {
        return userRepository.save(user);
    }


    @Override
    public User deleteOne(Integer id) {
        getOne(id);
        try {
            userRepository.deleteById(id);
        }catch (Exception e){
            throw new HandleException(ExceptionEnum.UNKNOWN_ERROR);
        }
        return null;
    }
}
