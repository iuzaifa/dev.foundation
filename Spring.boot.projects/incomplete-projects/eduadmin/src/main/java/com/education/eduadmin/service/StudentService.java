package com.education.eduadmin.service;

import com.education.eduadmin.dto.student.StudentRequestDto;
import com.education.eduadmin.dto.student.StudentResponseDto;

import java.util.List;

public interface StudentService {



    StudentResponseDto addNewStudent(StudentRequestDto requestDto);
    List<StudentResponseDto> getAllStudents();




}
