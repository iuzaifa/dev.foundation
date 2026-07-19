package com.coreSpringSecurity.service.serviceImpl;

import com.coreSpringSecurity.dto.EmployeeDTO;
import com.coreSpringSecurity.mapper.EmployeeMapper;
import com.coreSpringSecurity.model.Employee;
import com.coreSpringSecurity.repository.EmployeeRepository;
import com.coreSpringSecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmployeeMapper employeeMapper;



    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeedto) {
        Employee employee = employeeMapper.toEntity( employeedto);
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDto(savedEmployee);
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId).
                orElseThrow(() -> new RuntimeException("User not found with this id"));
        employeeRepository.deleteById(employee.getId());
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toDto)
                .toList();
    }

    @Override
    public EmployeeDTO employeeFindById(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId).
                orElseThrow(() -> new RuntimeException("User not found with this id"));
        return employeeMapper.toDto(employee);
    }

}
