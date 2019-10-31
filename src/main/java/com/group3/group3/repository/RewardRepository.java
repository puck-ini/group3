package com.group3.group3.repository;

import com.group3.group3.entity.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RewardRepository extends JpaRepository<Reward,Integer> {

    List<Reward> findAllByReName(String reName);


}
