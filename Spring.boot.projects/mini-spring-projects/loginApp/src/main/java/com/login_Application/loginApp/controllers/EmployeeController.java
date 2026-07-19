package com.login_Application.loginApp.controllers;

import com.login_Application.loginApp.entities.Employee;
import com.login_Application.loginApp.payload.EmployeeDto;
import com.login_Application.loginApp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create-employee")
    public Employee createEmployee(@RequestBody EmployeeDto employeeDto){

        return employeeService.createEmployee(employeeDto);

    }

    @GetMapping("/get-employee-ById/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/All-emp")
    public ResponseEntity<List<Employee>> getAllEmployee(Employee employee) {
        List<Employee> employees = employeeService.getAllEmployee(employee);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/get-old-employee/{departmentId}")
    public ResponseEntity<Employee> getOldEmployee (@PathVariable Integer departmentId){
        Employee employee = employeeService.getOldEmployee(departmentId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/get-young-employee/{departmentId}")
    public ResponseEntity<Employee> getYoungEmployee (@PathVariable Integer departmentId){
        Employee employee = employeeService.getYoungEmployee(departmentId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }



}
