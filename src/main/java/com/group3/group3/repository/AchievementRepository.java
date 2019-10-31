package com.group3.group3.repository;

import com.group3.group3.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement,Integer> {

    List<Achievement> findAllByUsername(String username);

    Achievement findByUidAndAeInformation(Integer uid,String aeInformation);

    List<Achievement> findAllByUid(Integer uid);
}
