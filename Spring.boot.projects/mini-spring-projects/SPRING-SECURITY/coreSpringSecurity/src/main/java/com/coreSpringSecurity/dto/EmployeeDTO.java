package com.coreSpringSecurity.dto;

import com.coreSpringSecurity.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {


    private int id;
    private String name;
    private String email;
    private String password;
    private String roles;

//    private List<Roles> roles = new ArrayList<>();


}
