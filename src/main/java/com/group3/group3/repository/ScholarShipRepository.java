package com.group3.group3.repository;

import com.group3.group3.entity.ScholarShip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScholarShipRepository extends JpaRepository<ScholarShip,Integer> {
    List<ScholarShip> findBySsid(Integer ssid);

    void deleteBySsid(Integer ssid);

    List<ScholarShip> findByTypeOrName(String type,String name);
}
