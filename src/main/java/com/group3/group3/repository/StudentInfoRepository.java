package com.group3.group3.repository;

import com.group3.group3.entity.StudentInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentInfoRepository extends JpaRepository<StudentInformation,Integer>{
}
