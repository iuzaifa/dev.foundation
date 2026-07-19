package com.coreSpringSecurity.service;

import com.coreSpringSecurity.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO createEmployee( EmployeeDTO employeedto);

    void deleteEmployee(Integer employeeId);

    List<EmployeeDTO> getAllEmployee();

    EmployeeDTO employeeFindById(Integer employeeId);
}
