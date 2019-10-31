package com.group3.group3.repository;

import com.group3.group3.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    List<Department> findByDeid(Integer deid);
    List<Department> findAllByDename(String dename);

}
