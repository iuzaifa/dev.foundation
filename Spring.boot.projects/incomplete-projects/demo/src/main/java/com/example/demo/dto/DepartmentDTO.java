package com.example.demo.dto;

public class DepartmentDTO {

    private int id;
    private String department;

    public DepartmentDTO() {
    }

    public DepartmentDTO(String department) {
        this.department = department;
    }

    public DepartmentDTO(int id, String department) {
        this.id = id;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "department='" + department + '\'' +
                '}';
    }
}
