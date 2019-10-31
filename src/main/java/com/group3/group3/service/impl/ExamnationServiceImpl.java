package com.group3.group3.service.impl;

import com.group3.group3.entity.Examination;
import com.group3.group3.repository.ExaminationRepository;
import com.group3.group3.repository.ClassRoomRepository;
import com.group3.group3.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ExamnationServiceImpl implements ExaminationService {

    @Autowired
    private ExaminationRepository examinationRepository;
    private ClassRoomRepository classRoomRepository;

    @Override
    public Examination insertExInfo(Examination examination) {
        examinationRepository.save(examination);
        return examination;
    }

    @Override
    public Examination deleteExInfo(Integer exid) {
        examinationRepository.deleteById(exid);
        return null;
    }


    @Override
    public Examination updateExInfo(Examination examination) {
        return examinationRepository.save(examination);
    }

    @Override
    public List<Examination> getAllExInfo() {
        return examinationRepository.findAll();
    }

    @Override
    public List<Examination> getOneExInfo(Integer uid) {
        return examinationRepository.findAllByUid(uid);
    }

    @Override
    public Examination getOne(Integer uid, Integer crid) {
        return examinationRepository.findByUidAndCrid(uid, crid);
    }
}
