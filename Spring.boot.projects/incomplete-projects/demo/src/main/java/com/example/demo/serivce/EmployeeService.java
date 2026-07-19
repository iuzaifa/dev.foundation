package com.example.demo.serivce;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee createEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.toEntity(employeeDto);
        if (employeeDto.getDepartmentDTOS() != null) {
            employee.setDepartments(
                    employeeDto.getDepartmentDTOS().stream()
                            .map(depDto -> {
                                Department department = new Department();
                                department.setDepartment(depDto.getDepartment());
                                department.setEmployee(employee);
                                return department;
                            })
                            .collect(Collectors.toList())
            );
        }
        return (employeeRepository.save(employee));
    }
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
    public Employee assignDepartment (String email, String department){
        Employee employee = employeeRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("employee not found"));
        Department addDepartment = departmentRepository.findByDepartment(department)
                .orElseThrow(() -> new RuntimeException("department not found"));

        addDepartment.setEmployee(employee);           // set employee in department
        employee.getDepartments().add(addDepartment);
        return  employeeRepository.save(employee);

    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }
    public Employee updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = getEmployeeById(id); // fetch existing employee

        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhone(employeeDto.getPhone());
        employee.setAddress(employeeDto.getAddress());

        // Update departments
        if (employeeDto.getDepartmentDTOS() != null) {
            employee.getDepartments().clear(); // remove old departments
            employee.getDepartments().addAll(
                    employeeDto.getDepartmentDTOS().stream()
                            .map(depDto -> {
                                Department dept = new Department();
                                dept.setDepartment(depDto.getDepartment());
                                dept.setEmployee(employee);
                                return dept;
                            })
                            .collect(Collectors.toList())
            );
        }

        return employeeRepository.save(employee);
    }
    public void deleteEmployeeById(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }

    public void deleteEmployeeByEmail(String email) {
        Employee employee = employeeRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employee not found with email: " + email));
        employeeRepository.delete(employee);
    }

}
