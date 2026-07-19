package com.example.demo.serivce;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.entity.Department;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentMapper departmentMapper;


    public Department createDepartment(DepartmentDTO departmentDTO){
        Department department = departmentMapper.toEntity(departmentDTO);
        return departmentRepository.save(department);
    }
}
