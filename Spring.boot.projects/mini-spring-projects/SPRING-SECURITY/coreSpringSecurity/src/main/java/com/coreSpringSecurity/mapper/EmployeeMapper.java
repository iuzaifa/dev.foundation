package com.coreSpringSecurity.mapper;

import com.coreSpringSecurity.dto.EmployeeDTO;
import com.coreSpringSecurity.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {


    EmployeeDTO toDto (Employee employee);
    Employee toEntity (EmployeeDTO employee);
}
