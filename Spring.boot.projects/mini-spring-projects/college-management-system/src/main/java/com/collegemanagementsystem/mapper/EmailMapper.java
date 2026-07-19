package com.collegemanagementsystem.mapper;

import com.collegemanagementsystem.model.Student;
import com.collegemanagementsystem.payloads.ChangeEmailDTO;

public class EmailMapper {

    // entity to dto
    public static ChangeEmailDTO toEmailDto(Student student){
        if (student == null) return  null;
        ChangeEmailDTO changeEmailDTO = new ChangeEmailDTO();

        changeEmailDTO.setEmail(student.getEmail());
        return changeEmailDTO;
    }

    // dto to entity
    public static Student toEmailEntity(ChangeEmailDTO changeEmailDTO){
        if (changeEmailDTO == null) return  null;
        Student student = new Student();
        student.setEmail(changeEmailDTO.getEmail());
        return student;
    }
}
