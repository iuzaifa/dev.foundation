package com.example.demo.dto;

public class AssignDepartmentRequest {
    private String email;
    private String department;

    public AssignDepartmentRequest() {
    }

    public AssignDepartmentRequest(String email, String department) {
        this.email = email;
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
