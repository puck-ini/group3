package com.group3.group3.service.impl;

import com.group3.group3.entity.ScholarShip;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.repository.ScholarShipRepository;
import com.group3.group3.service.ScholarShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ScholarShipServiceImpl implements ScholarShipService {

    @Autowired
    ScholarShipRepository scholarShipRepository;

    @Override
    public List<ScholarShip> getScholarShip(String type,String name) {
        List<ScholarShip>  scholarShips = scholarShipRepository.findByTypeOrName(type,name);
        return scholarShips;
    }

    @Override
    public ScholarShip insertScholarShip(ScholarShip scholarShip) {
        verifyScholarShip(scholarShip.getType(),scholarShip.getName());
        return scholarShipRepository.save(scholarShip);
    }

    @Override
    public void deleteScholarShip(Integer ssid) {
        scholarShipRepository.deleteBySsid(ssid);
    }

    @Override
    public ScholarShip updateScholarShip(ScholarShip scholarShip) {
        return scholarShipRepository.save(scholarShip);
    }

    @Override
    public List<ScholarShip> getAll() {
        return scholarShipRepository.findAll();
    }

    private void verifyScholarShip(String type,String name) {
        List<ScholarShip> scholarShips = scholarShipRepository.findByTypeOrName(type,name);
        if (scholarShips.size() != 0){
            throw new HandleException(ExceptionEnum.EXIST_SCHOLARSHIP);
        }
    }

}
