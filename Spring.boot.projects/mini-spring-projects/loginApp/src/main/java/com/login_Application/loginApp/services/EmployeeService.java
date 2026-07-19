package com.login_Application.loginApp.services;

import com.login_Application.loginApp.entities.Department;
import com.login_Application.loginApp.entities.Employee;
import com.login_Application.loginApp.payload.EmployeeDto;
import com.login_Application.loginApp.repository.DepartmentRepo;
import com.login_Application.loginApp.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private DepartmentRepo departmentRepo;

    public Employee createEmployee(EmployeeDto employeeDto) {
        Optional<Department> department = departmentRepo.findById(employeeDto.getDepartmentId());
        if (department.isEmpty()) {
            throw new RuntimeException("Invalid Department ID : " + employeeDto.getDepartmentId());
        }
        Employee employeeToSave = Employee.builder()
                .name(employeeDto.getName())
                .phone(employeeDto.getPhone())
                .age(employeeDto.getAge())
                .department(department.get())
                .build();
        return employeeRepo.save(employeeToSave);
    }


    public Employee getEmployeeById(Integer id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        return employee.get();
    }

    public List<Employee> getAllEmployee(Employee employee) {
        return employeeRepo.findAll();
    }

    public Employee getOldEmployee(Integer departmentId) {
        List<Employee> employees = employeeRepo.findByDepartmentId(departmentId);
        Optional<Employee> employee = employees.stream().max((e1, e2) -> Float.compare(e1.getAge(), e2.getAge()));
        return employee.get();
    }

    public Employee getYoungEmployee(Integer departmentId){
        List<Employee> employees = employeeRepo.findByDepartmentId(departmentId);
        Optional<Employee> employee = employees.stream().min((e1, e2)-> Float.compare(e1.getAge(), e2.getAge()));
        return employee.get();
    }
 }
