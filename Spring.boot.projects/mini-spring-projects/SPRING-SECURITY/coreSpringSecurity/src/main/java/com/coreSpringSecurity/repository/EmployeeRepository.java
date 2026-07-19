package com.coreSpringSecurity.repository;

import com.coreSpringSecurity.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{



    @Query(value = "SELECT * FROM employee where name = :username", nativeQuery = true)
    Optional<Employee> findByUsername(@Param("username") String username);
}
