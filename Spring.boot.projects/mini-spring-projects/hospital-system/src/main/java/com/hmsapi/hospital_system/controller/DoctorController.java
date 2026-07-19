package com.hmsapi.hospital_system.controller;

import com.hmsapi.hospital_system.response.ApiResponse;
import com.hmsapi.hospital_system.response.DoctorRequest;
import com.hmsapi.hospital_system.response.DoctorResponse;
import com.hmsapi.hospital_system.service.IDoctorService;
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
@RequestMapping("hospital/api/doctors")
public class DoctorController {

    private final IDoctorService doctorService;


    @GetMapping("/get/all-doctors")
    public ResponseEntity<ApiResponse<?>> getAllDoctors(){
        String message = "Doctors fetched successfully";
        List<DoctorResponse> doctors = doctorService.getAllDoctors();

        Map<String, Object> metadata = new HashMap<>();
        metadata.put("totalCount", doctors.size());
        metadata.put("page", 1);
        metadata.put("size", doctors.size());

        ApiResponse<List<?>> response = new ApiResponse<>(
                message,
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                metadata,
                doctors
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create/new-doctor")
    public ResponseEntity<ApiResponse<?>> createDoctors(@Valid @RequestBody DoctorRequest doctorRequest){
        String message = "Doctor Created successfully";
        DoctorResponse doctors = doctorService.createDoctor(doctorRequest);
        ApiResponse<DoctorResponse> response = new ApiResponse<>(
                message,
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                null,
                doctors
        );
        return  ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/get/doctor/{id}")
    public ResponseEntity<ApiResponse<?>> createDoctors(@PathVariable("id") Long id){
        String message = "Doctors fetched successfully";
        DoctorResponse doctor = doctorService.getDoctorById(id);
        ApiResponse<DoctorResponse> response = new ApiResponse<>(
                message,
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                null,
                doctor
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/doctor/by-email")
    public ResponseEntity<ApiResponse<?>> createDoctors(@RequestParam("email") String email){
        String message = "Doctors fetched successfully";
        DoctorResponse doctor = doctorService.getDoctorByEmail(email);
        ApiResponse<DoctorResponse> response = new ApiResponse<>(
                message,
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                null,
                doctor
        );
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/doctor/{id}")
    public ResponseEntity<ApiResponse<?>> updateDoctorById(@PathVariable("id") Long id,
                                                           @Valid @RequestBody DoctorRequest doctorRequest){
        String message = "Doctors updated successfully";
        DoctorResponse doctor = doctorService.updateDoctorById(id, doctorRequest);
        ApiResponse<DoctorResponse> response = new ApiResponse<>(
                message,
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                null,
                doctor
        );
        return ResponseEntity.ok(response);
    }


    @PutMapping("/update/doctor/by-email")
    public ResponseEntity<ApiResponse<?>> updateDoctorByEmail(@RequestParam("email") String email,
                                                              @Valid @RequestBody DoctorRequest doctorRequest){
        String message = "Doctors updated successfully";
        DoctorResponse doctor = doctorService.updateDoctorByEmail(email, doctorRequest);
        ApiResponse<DoctorResponse> response = new ApiResponse<>(
                message,
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                null,
                doctor
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/doctor/{id}")
    public ResponseEntity<ApiResponse<?>> deleteDoctorById(@PathVariable("id") Long id){
        String message = "Doctors Deleted successfully";
        doctorService.deleteDoctorById(id);
        ApiResponse<DoctorResponse> response = new ApiResponse<>(
                message,
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                null,
                null
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/doctor/by-email")
    public ResponseEntity<ApiResponse<?>> deleteDoctorByEmail(@RequestParam("email") String email){
        String message = "Doctors Deleted successfully";
        doctorService.deleteDoctorByEmail(email);
        ApiResponse<DoctorResponse> response = new ApiResponse<>(
                message,
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                null,
                null
        );
        return ResponseEntity.ok(response);
    }


}
