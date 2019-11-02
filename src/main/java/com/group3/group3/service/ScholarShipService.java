package com.group3.group3.service;

import com.group3.group3.entity.ScholarShip;

import java.util.List;

public interface ScholarShipService {
    List<ScholarShip> getScholarShip(String type,String name);

    ScholarShip insertScholarShip(ScholarShip scholarShip);

    void deleteScholarShip(Integer ssid);

    ScholarShip updateScholarShip(ScholarShip scholarShip);

    List<ScholarShip> getAll();
}
