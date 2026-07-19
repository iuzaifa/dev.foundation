package com.collegemanagementsystem.controller;

import com.collegemanagementsystem.constant.CommonConstants;
import com.collegemanagementsystem.payloads.ChangeEmailDTO;
import com.collegemanagementsystem.payloads.StudentDTO;
import com.collegemanagementsystem.payloads.StudentRegisterDTO;
import com.collegemanagementsystem.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CommonConstants.API_BASE_PATH)
public class StudentController {

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @PostMapping(CommonConstants.REGISTER_NEW_STUDENT)
    public ResponseEntity<?> registerStudent(@RequestBody StudentRegisterDTO registerDTO){
        return new ResponseEntity<>(studentServiceImpl.registerNewStudent(registerDTO), HttpStatus.CREATED);
    }



    @GetMapping(CommonConstants.GET_ALL_STUDENT)
    public ResponseEntity<?> getAllStudents(){
        return new ResponseEntity<>(studentServiceImpl.getAllStudent(), HttpStatus.OK);
    }


    @PutMapping(CommonConstants.UPDATE_STUDENT_VIA_ID)
    public ResponseEntity<?> updateStudentById(@PathVariable("studentId") Integer studentId, @RequestBody StudentDTO studentDTO){
        return new ResponseEntity<>(studentServiceImpl.updateStudentDetails(studentId, studentDTO), HttpStatus.OK);
    }

    @DeleteMapping(CommonConstants.DELETE_STUDENT_VIA_ID)
    public ResponseEntity<?> deleteStudentByID(@PathVariable("studentId") Integer studentId){
        String message = "STUDENT DELETED SUCCESSFULLY : "+ studentId;
        studentServiceImpl.deleteStudentByID(studentId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping(CommonConstants.STUDENT_FIND_VIA_ID)
    public ResponseEntity<?> studentFindByID(@PathVariable("studentId") Integer studentId){
        return new ResponseEntity<>(studentServiceImpl.studentFindByID(studentId), HttpStatus.OK);
    }

    @PatchMapping(CommonConstants.CHANGE_EMAIL_VIA_ID)
    public ResponseEntity<?> changeEmail(@PathVariable("studentId") Integer studentId,@RequestBody ChangeEmailDTO changeEmailDTO) {
        return new ResponseEntity<>(studentServiceImpl.changeEmail(studentId, changeEmailDTO), HttpStatus.OK);
    }
}