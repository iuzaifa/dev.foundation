package com.collage.application.service.serviceImpl;

import com.collage.application.dto.StudentRequestDto;
import com.collage.application.dto.StudentResponseDto;
import com.collage.application.entity.Student;
import com.collage.application.mapper.StudentMapper;
import com.collage.application.repository.StudentRepository;
import com.collage.application.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudentResponseDto createStudent(StudentRequestDto requestDto) {
        Student student = studentMapper.toEntity(requestDto);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toResponseDto(student);
    }
}

