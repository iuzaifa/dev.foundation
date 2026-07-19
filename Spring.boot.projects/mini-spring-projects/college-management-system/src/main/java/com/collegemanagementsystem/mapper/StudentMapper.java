package com.collegemanagementsystem.mapper;

import com.collegemanagementsystem.payloads.StudentDTO;
import com.collegemanagementsystem.model.Student;

public class StudentMapper {


    // entity to dto
    public static StudentDTO toStudentDto(Student student){
        if (student == null) return null;

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId(student.getId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setStandard(student.getStandard());
        studentDTO.setGender(student.getGender());
        studentDTO.setDateOfBirth(student.getDateOfBirth());
        studentDTO.setPassword(student.getPassword());
        studentDTO.setConfirmPassword(student.getConfirmPassword());
        studentDTO.setAddress(student.getAddress());
        studentDTO.setCity(student.getCity());
        studentDTO.setState(student.getState());
        studentDTO.setPostalCode(student.getPostalCode());
        studentDTO.setCountry(student.getCountry());
        studentDTO.setActive(student.isActive()); // Assuming Student entity has isActive() getter
        studentDTO.setCreatedAt(student.getCreatedAt());
        studentDTO.setUpdatedAt(student.getUpdatedAt());
        return studentDTO;
    }


    // dto to entity
    public static Student toStudentEntity(StudentDTO dto){

        if (dto == null) return null;

        Student studentEntity = new Student();

        studentEntity.setId(dto.getId());
        studentEntity.setFirstName(dto.getFirstName());
        studentEntity.setLastName(dto.getLastName());
        studentEntity.setEmail(dto.getEmail());
        studentEntity.setStandard(dto.getStandard());
        studentEntity.setGender(dto.getGender());
        studentEntity.setDateOfBirth(dto.getDateOfBirth());
        studentEntity.setPassword(dto.getPassword());
        studentEntity.setConfirmPassword(dto.getConfirmPassword());
        studentEntity.setAddress(dto.getAddress());
        studentEntity.setCity(dto.getCity());
        studentEntity.setState(dto.getState());
        studentEntity.setPostalCode(dto.getPostalCode());
        studentEntity.setCountry(dto.getCountry());
        studentEntity.setActive(dto.isActive()); // Assuming Student entity has isActive() getter
        studentEntity.setCreatedAt(dto.getCreatedAt());
        studentEntity.setUpdatedAt(dto.getUpdatedAt());
        // return student studentEntity
        return studentEntity;
    }


}
