package com.education.eduadmin.controller;

import com.education.eduadmin.dto.student.StudentRequestDto;
import com.education.eduadmin.dto.student.StudentResponseDto;
import com.education.eduadmin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentController {


    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<StudentResponseDto> addNewStudent(@RequestBody StudentRequestDto requestDto){
        return  new ResponseEntity<>(studentService.addNewStudent(requestDto), HttpStatus.CREATED);
    }


    @GetMapping("/get-all")
    public ResponseEntity<List<StudentResponseDto>> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }







}
