package com.collage.application.controller;

import com.collage.application.dto.StudentRequestDto;
import com.collage.application.dto.StudentResponseDto;
import com.collage.application.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/student")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<StudentResponseDto> createStudent(@RequestBody StudentRequestDto requestDto){
        return new ResponseEntity<>(studentService.createStudent(requestDto), HttpStatus.CREATED);
    }
}
