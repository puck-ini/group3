package com.group3.group3.repository;

import com.group3.group3.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade,Integer> {
    List<Grade> findAllByCname(String cname);

    Grade findByUidAndCname(Integer uid,String cname);

    List<Grade> findAllByUsername(String username);

    List<Grade> findByUsernameAndCname(String username,String cname);

}
