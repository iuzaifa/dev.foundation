package com.collage.application.service;


import com.collage.application.dto.StudentRequestDto;
import com.collage.application.dto.StudentResponseDto;

public interface StudentService {


    StudentResponseDto createStudent(StudentRequestDto requestDto);



}
