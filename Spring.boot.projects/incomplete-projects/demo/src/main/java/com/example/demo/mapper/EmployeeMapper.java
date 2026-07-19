package com.example.demo.mapper;


import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {


    Employee toEntity(EmployeeDto employeeDto);
    EmployeeDto toDot (Employee employee);
}
