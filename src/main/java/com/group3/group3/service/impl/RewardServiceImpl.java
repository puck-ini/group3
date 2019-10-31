package com.group3.group3.service.impl;

import com.group3.group3.entity.Reward;
import com.group3.group3.repository.ResearchRepository;
import com.group3.group3.repository.RewardRepository;
import com.group3.group3.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardServiceImpl implements RewardService {

    @Autowired
    private RewardRepository rewardRepository;

    @Override
    public Reward insert(Reward reward) {
        return rewardRepository.save(reward);
    }

    @Override
    public Reward delete(Integer reid) {
        rewardRepository.deleteById(reid);
        return null;
    }

    @Override
    public List<Reward> getAll() {
        return rewardRepository.findAll();
    }

    @Override
    public List<Reward> getPersonInfo(String reName) {
        return rewardRepository.findAllByReName(reName);
    }
}
