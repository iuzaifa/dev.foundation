package com.hospital.hms.mapper;

import com.hospital.hms.dto.PatientRequestDto;
import com.hospital.hms.dto.PatientResponseDto;
import com.hospital.hms.entity.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient toPatientEntity(PatientRequestDto patientRequestDto);
    PatientResponseDto toPatientResponseDto(Patient patient);
}
