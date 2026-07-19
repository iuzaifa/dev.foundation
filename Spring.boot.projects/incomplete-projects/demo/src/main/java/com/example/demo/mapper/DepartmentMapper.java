package com.example.demo.mapper;


import com.example.demo.dto.DepartmentDTO;
import com.example.demo.entity.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    Department toEntity(DepartmentDTO departmentDTO);

    DepartmentDTO toDto(Department department);
}
