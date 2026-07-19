package com.springsecurity_example.services;

import com.springsecurity_example.dto.EmployeeDTO;
import com.springsecurity_example.entities.Employee;

import java.util.List;

public interface EmployeeService {


    Employee createEmployee(Employee employee);


    List<Employee> getAllEmployees();

    Employee getEmployeeBYId(Integer empId);

    void deleteEmployeeById(Integer empId);

    Employee updateEmployeeById(Integer empId,  EmployeeDTO employeeDTO);


}
