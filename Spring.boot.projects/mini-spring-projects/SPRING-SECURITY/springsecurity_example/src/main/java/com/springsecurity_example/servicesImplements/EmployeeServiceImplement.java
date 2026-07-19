package com.springsecurity_example.servicesImplements;

import com.springsecurity_example.dto.EmployeeDTO;
import com.springsecurity_example.entities.Employee;
import com.springsecurity_example.repository.EmployeeRepository;
import com.springsecurity_example.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplement implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Employee createEmployee(Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeBYId(Integer empId) {
        return employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found" + empId));
    }

    @Override
    public void deleteEmployeeById(Integer empId) {
        if (!employeeRepository.existsById(empId)){
            throw new RuntimeException("Employee not found: " + empId);
        }
        employeeRepository.deleteById(empId);

    }

    @Override
    public Employee updateEmployeeById(Integer empId,  EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + empId));
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDesignation(employeeDTO.getDesignation());
        employee.setPassword(passwordEncoder.encode(employeeDTO.getPassword()));
        employee.setRoles(employeeDTO.getRoles());
        return employeeRepository.save(employee);
    }


}
