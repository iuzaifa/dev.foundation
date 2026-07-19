package com.hmsapi.hospital_system.response;


import com.hmsapi.hospital_system.model.AppointmentStatus;
import com.hmsapi.hospital_system.model.Doctor;
import com.hmsapi.hospital_system.model.Patient;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class AppointmentRequest {




    private Patient patient;
    private Doctor doctor;

    private LocalDate appointmentDate;
    private LocalTime appointmentTime;

    private AppointmentStatus status;

    private String remarks;

    private LocalDateTime createdAt = LocalDateTime.now();

}
