package com.collegemanagementsystem.service.impl;

import com.collegemanagementsystem.mapper.EmailMapper;
import com.collegemanagementsystem.payloads.ChangeEmailDTO;
import com.collegemanagementsystem.payloads.StudentDTO;
import com.collegemanagementsystem.payloads.StudentRegisterDTO;
import com.collegemanagementsystem.mapper.RegisterMapper;
import com.collegemanagementsystem.mapper.StudentMapper;
import com.collegemanagementsystem.model.Student;
import com.collegemanagementsystem.repository.StudentRepository;
import com.collegemanagementsystem.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentRegisterDTO registerNewStudent(StudentRegisterDTO registerDTO) {
        Optional<Student> existingEmail = studentRepository.findByEmail(registerDTO.getEmail());
        if (existingEmail.isPresent()){
            throw new RuntimeException("Email is Already exits try another email : " + registerDTO.getEmail());
        }
        Student student = RegisterMapper.toRegisterEntity(registerDTO);
        student.setCreatedAt(LocalDateTime.now());
        student.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        student = studentRepository.save(student);
        return RegisterMapper.toRegisterDTO(student);
    }




    @Override
    public List<StudentDTO> getAllStudent() {
        return studentRepository.findAll().stream().map(StudentMapper::toStudentDto).toList();
    }



    @Override
    public StudentDTO updateStudentDetails(Integer studentId, StudentDTO studentDTO) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new RuntimeException("ID ALREADY EXITS TRY AGAIN" + studentId));

        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setStandard(studentDTO.getStandard());
        student.setGender(studentDTO.getGender());
        student.setDateOfBirth(studentDTO.getDateOfBirth());
        student.setAddress(studentDTO.getAddress());
        student.setCity(studentDTO.getCity());
        student.setState(studentDTO.getState());
        student.setPostalCode(studentDTO.getPostalCode());
        student.setCountry(studentDTO.getCountry());
        student.setActive(studentDTO.isActive());
        student.setUpdatedAt(LocalDateTime.now());
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.toStudentDto(savedStudent);
    }

    @Override
    public void deleteStudentByID(Integer studentID) {
        Student student = studentRepository.findById(studentID)
                .orElseThrow(()-> new RuntimeException("STUDENT NOT FOUND"));
        studentRepository.deleteById(student.getId());
    }

    @Override
    public StudentDTO studentFindByID(Integer studentID) {
        Student student = studentRepository.findById(studentID)
                .orElseThrow(()-> new RuntimeException("STUDENT NOT FOUND"));
        return StudentMapper.toStudentDto(student);
    }

    @Override
    public ChangeEmailDTO changeEmail(Integer studentID, ChangeEmailDTO changeEmailDTO) {
        Student student = studentRepository.findById(studentID)
                .orElseThrow(()-> new RuntimeException("STUDENT NOT FOUND"));

        student.setEmail(changeEmailDTO.getEmail());

        Student savedNewEmail = studentRepository.save(student);
        return EmailMapper.toEmailDto(savedNewEmail);
    }


}
