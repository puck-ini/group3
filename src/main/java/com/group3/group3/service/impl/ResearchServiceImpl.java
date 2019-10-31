package com.group3.group3.service.impl;

import com.group3.group3.entity.Research;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.repository.ResearchRepository;
import com.group3.group3.service.ResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResearchServiceImpl implements ResearchService {

    @Autowired
    private ResearchRepository researchRepository;

    @Override
    public Research insertOne(Research research) {
        verifyExit(research.getUid(),research.getResearchName());
        researchRepository.save(research);
        return research;
    }

    private void verifyExit(Integer uid,String researchName){
        Research research = researchRepository.findByUidAndResearchName(uid, researchName);
        if (research!=null){
            throw new HandleException(ExceptionEnum.EXIST_RESEARCHINFO);
        }
    }

    @Override
    public Research updateOne(Research research) {
        return researchRepository.save(research);
    }

    @Override
    public Research deleteOne(Integer researchid) {
        researchRepository.deleteById(researchid);
        return null;
    }

    @Override
    public List<Research> getAllReInfo() {
        return researchRepository.findAll();
    }

    @Override
    public List<Research> getPersonInfo(String username) {
        return researchRepository.findAllByUsername(username);
    }

    @Override
    public List<Research> getOneReAllInfo(String researchName) {
        return researchRepository.findAllByResearchNameLike(researchName);
    }

    @Override
    public Research getOne(Integer uid, String researchName) {
        return researchRepository.findByUidAndResearchName(uid, researchName);
    }
}
