package com.group3.group3.service;

import com.group3.group3.entity.Reward;

import java.util.List;

public interface RewardService {

    Reward insert(Reward reward);

    Reward delete(Integer reid);

    List<Reward> getAll();

    List<Reward> getPersonInfo(String reName);

}
