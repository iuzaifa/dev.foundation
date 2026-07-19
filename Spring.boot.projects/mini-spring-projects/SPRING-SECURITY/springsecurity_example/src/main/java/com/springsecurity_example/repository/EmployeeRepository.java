package com.springsecurity_example.repository;

import com.springsecurity_example.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    @Query( value = "select * from employee where email =:email", nativeQuery = true)
    Optional<Employee> findByEmail(@Param("email") String email);
}
