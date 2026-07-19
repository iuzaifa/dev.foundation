package com.coreSpringSecurity.dto;

import com.coreSpringSecurity.model.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RolesDTO {


    private String roles;
    private List<Employee> employees = new ArrayList<>();

}
