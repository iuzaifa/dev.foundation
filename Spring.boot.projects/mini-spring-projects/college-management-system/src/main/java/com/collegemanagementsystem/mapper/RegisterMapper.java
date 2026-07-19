package com.collegemanagementsystem.mapper;

import com.collegemanagementsystem.payloads.StudentRegisterDTO;
import com.collegemanagementsystem.model.Student;

public class RegisterMapper {


    // entity to dto
    public static StudentRegisterDTO toRegisterDTO (Student student){
        if (student == null) return null;
        StudentRegisterDTO dto = new StudentRegisterDTO();
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setEmail(student.getEmail());
        dto.setGender(student.getGender());
        dto.setDateOfBirth(student.getDateOfBirth());
        dto.setPassword(student.getPassword());
        dto.setConfirmPassword(student.getConfirmPassword());
        dto.setCreatedAt(student.getCreatedAt());
        return dto;
    }
    // dto to entity

    public static Student toRegisterEntity (StudentRegisterDTO dto){
        if (dto == null) return null;
        Student student = new Student();

        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setGender(dto.getGender());
        student.setDateOfBirth(dto.getDateOfBirth());
        student.setPassword(dto.getPassword());
        student.setConfirmPassword(dto.getConfirmPassword());
        student.setCreatedAt(dto.getCreatedAt());
        return student;
    }
}
