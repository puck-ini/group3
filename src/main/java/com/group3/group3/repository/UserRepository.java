package com.group3.group3.repository;

import com.group3.group3.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findByUsername(String username);
}
