package com.education.eduadmin.service.serviceImpl;

import com.education.eduadmin.dto.student.StudentRequestDto;
import com.education.eduadmin.dto.student.StudentResponseDto;
import com.education.eduadmin.entity.Student;
import com.education.eduadmin.exceptions.AlreadyExitsException;
import com.education.eduadmin.mapper.StudentMapper;
import com.education.eduadmin.repository.StudentRepository;
import com.education.eduadmin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public StudentResponseDto addNewStudent(StudentRequestDto requestDto) {
        boolean isEmailExists = studentRepository.existsByEmail(requestDto.getEmail());
        boolean isPhoneExists = studentRepository.existsByPhone(requestDto.getPhone());
        if (isEmailExists){
            throw new AlreadyExitsException(requestDto.getEmail() + " email id already exists try another");
        }
        if (isPhoneExists){
            throw new AlreadyExitsException(requestDto.getPhone() +  " phone number already exists try another");
        }
        Student student = studentMapper.toEntity(requestDto);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toResponseDto(savedStudent);
    }


    @Override
    public List<StudentResponseDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(studentMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
