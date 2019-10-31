package com.group3.group3.repository;

import com.group3.group3.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity,Integer> {

    List<Activity> findAllByUsername(String username);


    Activity findByUsernameAndName(String username,String name);
}
