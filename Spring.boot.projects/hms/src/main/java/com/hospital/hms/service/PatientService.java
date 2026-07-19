package com.hospital.hms.service;

import com.hospital.hms.dto.PatientRequestDto;
import com.hospital.hms.dto.PatientResponseDto;

import java.util.List;

public interface PatientService {

    PatientResponseDto addNewPatient(PatientRequestDto requestDto);
    List<PatientResponseDto> getAllPatient();

}
