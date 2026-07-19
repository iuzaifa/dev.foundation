package com.login_Application.loginApp.payload;

import lombok.Data;

@Data
public class EmployeeDto {

    private String name;
    private float age;
    private String phone;
    private int departmentId;
}
