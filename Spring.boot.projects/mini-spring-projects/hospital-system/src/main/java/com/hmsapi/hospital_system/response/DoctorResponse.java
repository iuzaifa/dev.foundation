package com.hmsapi.hospital_system.response;

import com.hmsapi.hospital_system.model.DoctorStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DoctorResponse {

    private Long id;
    private String email;
    private String name;
    private String fatherName;
    private String gender;
    private int age;

    private String contactNumber;
    private String specialization;
    private String qualification;
    private int yearsOfExperience;
    private LocalDate joiningDate;

    @Enumerated(EnumType.STRING)
    private DoctorStatus status;
    private boolean available;
}
