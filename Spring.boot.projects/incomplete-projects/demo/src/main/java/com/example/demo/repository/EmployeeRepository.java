package com.example.demo.repository;


import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Query(value = "SELECT * FROM employee WHERE email = :email", nativeQuery = true)
    Optional<Employee> findByEmail(@Param("email") String email);


}

