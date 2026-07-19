package com.collage.application.mapper;

import com.collage.application.dto.StudentRequestDto;
import com.collage.application.dto.StudentResponseDto;
import com.collage.application.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {


    StudentResponseDto toResponseDto(Student student);
    Student toEntity(StudentRequestDto requestDto);
}
