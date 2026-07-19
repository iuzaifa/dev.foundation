package com.example.demo.repository;

import com.example.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
//
//    @Query(value = "select * from department where department =: department)
//    Optional<Department> findByDepartment(String department);

    @Query(value = "SELECT * FROM department WHERE department = :department", nativeQuery = true)
    Optional<Department> findByDepartment(@Param("department") String department);



}
