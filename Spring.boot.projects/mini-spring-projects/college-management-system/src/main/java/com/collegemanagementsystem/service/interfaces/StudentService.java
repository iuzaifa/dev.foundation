package com.collegemanagementsystem.service.interfaces;


import com.collegemanagementsystem.payloads.ChangeEmailDTO;
import com.collegemanagementsystem.payloads.StudentDTO;
import com.collegemanagementsystem.payloads.StudentRegisterDTO;

import java.util.List;

public interface StudentService {

    StudentRegisterDTO registerNewStudent(StudentRegisterDTO registerDTO);

    List<StudentDTO> getAllStudent();

    StudentDTO updateStudentDetails (Integer studentID, StudentDTO studentDTO);

    void deleteStudentByID(Integer studentID);

    StudentDTO studentFindByID(Integer studentID);

    ChangeEmailDTO changeEmail(Integer studentID, ChangeEmailDTO changeEmailDTO);

}
