package com.example.demo.dto;


import java.util.ArrayList;
import java.util.List;


public class EmployeeDto {

    private String name;
    private String email;
    private String phone;
    private String address;
    private List<DepartmentDTO> departmentDTOS = new ArrayList<>();


    public EmployeeDto() {
    }

    public EmployeeDto(String name, String email, String phone, String address, List<DepartmentDTO> departmentDTOS) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.departmentDTOS = departmentDTOS;
    }

    public EmployeeDto(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public List<DepartmentDTO> getDepartmentDTOS() {
        return departmentDTOS;
    }

    public void setDepartmentDTOS(List<DepartmentDTO> departmentDTOS) {
        this.departmentDTOS = departmentDTOS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
