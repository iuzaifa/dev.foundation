package com.springsecurity_example.controllers;

import com.springsecurity_example.dto.EmployeeDTO;
import com.springsecurity_example.entities.Employee;
import com.springsecurity_example.servicesImplements.EmployeeServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeControllers {

    @Autowired
    private EmployeeServiceImplement employeeServiceImplement;

    /**
     * SUPER ADMIN -> CREATE, DELETE, UPDATE, GET-2
     * ADMIN - > UPDATE , GET , POST
     * USER -> GET, CREATE
     * */

//    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN', 'ROLE_ADMIN')") // ADMIN
    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeServiceImplement.createEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/all")
//    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(employeeServiceImplement.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{employee_id}")
//    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<?> employeeGetBYID(@PathVariable("employee_id") Integer employee_id){
        return new ResponseEntity<>(employeeServiceImplement.getEmployeeBYId(employee_id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{employee_id}")
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN')")
    public ResponseEntity<?> deleteEmployee(@PathVariable("employee_id") Integer employee_id){
        employeeServiceImplement.deleteEmployeeById(employee_id);
        String message = "Employee Deleted Successfully " + employee_id;
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/update/{employee_id}")
//    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN')")
    public ResponseEntity<?> updateEmployee(@PathVariable("employee_id") Integer employee_id, @RequestBody EmployeeDTO employeeDTO) {
        Employee updatedEmployee = employeeServiceImplement.updateEmployeeById(employee_id, employeeDTO );
        return ResponseEntity.ok(updatedEmployee);
    }




}
