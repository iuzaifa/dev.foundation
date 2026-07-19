package com.login_Application.loginApp.controllers;

import com.login_Application.loginApp.entities.Department;
import com.login_Application.loginApp.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/create-department")
    public Department createDepartment(@RequestBody Department department){
        return departmentService.createDepartment(department);
    }
}
