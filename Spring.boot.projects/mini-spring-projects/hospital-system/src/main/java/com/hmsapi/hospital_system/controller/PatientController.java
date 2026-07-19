package com.hmsapi.hospital_system.controller;


import com.hmsapi.hospital_system.response.ApiResponse;
import com.hmsapi.hospital_system.response.PatientRequest;
import com.hmsapi.hospital_system.response.PatientResponse;
import com.hmsapi.hospital_system.service.IPatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hospital/api/patient")
public class PatientController {

    private final IPatientService patientService;


    // GET ALL PATIENTS
    @GetMapping("/get-all-patients")
    public ResponseEntity<ApiResponse<List<PatientResponse>>> getAllPatients (){
        String apiMessage = "Patients fetched successfully";
        List<PatientResponse> patients = patientService.getAllPatient();

        Map<String, Object> metadata = new HashMap<>();
        metadata.put("totalCount", patients.size());
        metadata.put("page", 1); // set actual page number if paginated
        metadata.put("size", patients.size());
        ApiResponse<List<PatientResponse>> response = new ApiResponse<>(
                apiMessage,
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                metadata,
                patients
        );
        return ResponseEntity.ok(response);
    }



    // REGISTER A PATIENT
    @PostMapping("/register-patient") //
    public ResponseEntity<ApiResponse<?>> registerPatient(@Valid @RequestBody PatientRequest patientRequest){
        String apiMessage = "Patient created successfully";
        PatientResponse patientResponse = patientService.registerPatientDetails(patientRequest);
        ApiResponse<PatientResponse> response = new ApiResponse<>(
                apiMessage,
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                null,
                patientResponse
        );
        return  ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // REGISTER A PATIENT
    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse<?>> patientGetById(@PathVariable("id") Long id){
        String apiMessage = "Patient Find by id successfully";
        PatientResponse patientResponse = patientService.getPatientById(id);
        ApiResponse<PatientResponse> response = new ApiResponse<>(
                apiMessage,
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                null,
                patientResponse
        );
        return  ResponseEntity.ok(response);
    }

    // PATIENT GET BY EMAIL
    @GetMapping("/get/email")
    public ResponseEntity<ApiResponse<?>> patientGetByEmail(@RequestParam("email") String email){
        String apiMessage = "Patient Find by email successfully";
        PatientResponse patientResponse = patientService.getPatientByEmail(email);
        ApiResponse<PatientResponse> response = new ApiResponse<>(
                apiMessage,
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                null,
                patientResponse
        );
        return  ResponseEntity.ok(response);
    }

    // patientGetByPhone
    @GetMapping("/get/phone")
    public ResponseEntity<ApiResponse<?>> patientGetByPhone(@RequestParam("phone") String phone){
        String apiMessage = "Patient Find by phone successfully";


        PatientResponse patientResponse = patientService.getPatientByPhone(phone);
        ApiResponse<PatientResponse> response = new ApiResponse<>(
                apiMessage,
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                null,
                patientResponse
        );
        return  ResponseEntity.ok(response);
    }


    // deletePatientById deletePatientByEmail

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<?>> deleteById(@PathVariable("id") Long id){
        String apiMessage = "Patient Deleted Successfully ";
        patientService.deletePatientById(id);
        ApiResponse<PatientResponse> response = new ApiResponse<>(
                apiMessage,
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                null,
                null
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/email")
    public ResponseEntity<ApiResponse<?>> deleteByEmail(@RequestParam("email") String email){
        String apiMessage = "Patient Deleted Successfully ";
        patientService.deletePatientByEmail(email);
        ApiResponse<PatientResponse> response = new ApiResponse<>(
                apiMessage,
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                null,
                null
        );
        return ResponseEntity.ok(response);
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<?>> updateById(@PathVariable("id") Long id,
                                                     @Valid @RequestBody PatientRequest patientRequest){
        String apiMessage = "Patient updated Successfully ";
        PatientResponse patientResponse = patientService.updatePatientById(id, patientRequest);
        ApiResponse<PatientResponse> response = new ApiResponse<>(
                apiMessage,
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                null,
                patientResponse
        );
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/by-email")
    public ResponseEntity<ApiResponse<?>> updateByEmail(@RequestParam("email") String email,
                                                        @Valid @RequestBody PatientRequest patientRequest){
        String apiMessage = "Patient updated Successfully ";
        PatientResponse patientResponse = patientService.updatePatientByEmail(email, patientRequest);
        ApiResponse<PatientResponse> response = new ApiResponse<>(
                apiMessage,
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                null,
                patientResponse
        );
        return ResponseEntity.ok(response);
    }





}
