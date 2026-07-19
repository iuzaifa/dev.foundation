package com.login_Application.loginApp.repository;

import com.login_Application.loginApp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    @Query(value = "select * from employee where department_id =:id" , nativeQuery = true)
    List<Employee> findByDepartmentId(@Param("id") int departmentId);
}
