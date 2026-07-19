package com.hospital.hms.controller;

import com.hospital.hms.dto.PatientRequestDto;
import com.hospital.hms.dto.PatientResponseDto;
import com.hospital.hms.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    private final PatientService patientService;


    @PostMapping("/add")
    ResponseEntity<PatientResponseDto> createPatient(@Validated @RequestBody PatientRequestDto requestDto){
        return new ResponseEntity<>(patientService.addNewPatient(requestDto),
                HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    ResponseEntity<List<PatientResponseDto>> getAllPatients(){
        return new ResponseEntity<>(patientService.getAllPatient(), HttpStatus.OK);
    }

}
