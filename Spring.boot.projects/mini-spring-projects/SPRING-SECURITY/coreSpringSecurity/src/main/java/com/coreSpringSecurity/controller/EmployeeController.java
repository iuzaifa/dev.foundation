package com.coreSpringSecurity.controller;


import com.coreSpringSecurity.constants.CommonConstants;
import com.coreSpringSecurity.dto.EmployeeDTO;
import com.coreSpringSecurity.service.serviceImpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CommonConstants.EMPLOYEE_BASE_PATH)
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping(CommonConstants.CREATE_EMPLOYEE)
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        return new ResponseEntity<>(employeeService.createEmployee(employeeDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(CommonConstants.DELETE_EMPLOYEE_BY_ID)
    public ResponseEntity<?> deleteEmployee(@PathVariable("employeeId") Integer employeeId){
        String message = "Employee Deleted Successfully !";
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping(CommonConstants.GET_EMPLOYEE_BY_ID)
    public ResponseEntity<?> getEmployeeByID(@PathVariable("employeeId") Integer employeeId){
        return new ResponseEntity<>(employeeService.employeeFindById(employeeId), HttpStatus.OK);
    }

    @GetMapping(CommonConstants.GET_ALL_EMPLOYEE)
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(){
        return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
    }

}
