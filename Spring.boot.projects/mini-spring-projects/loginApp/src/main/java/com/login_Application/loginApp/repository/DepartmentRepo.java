package com.login_Application.loginApp.repository;


import com.login_Application.loginApp.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {
}
