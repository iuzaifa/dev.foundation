package com.login_Application.loginApp.services;

import com.login_Application.loginApp.entities.Department;
import com.login_Application.loginApp.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public Department createDepartment(Department department) {
        return departmentRepo.save(department);
    }

}
