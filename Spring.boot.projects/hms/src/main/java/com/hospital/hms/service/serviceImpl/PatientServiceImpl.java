package com.hospital.hms.service.serviceImpl;

import com.hospital.hms.dto.PatientRequestDto;
import com.hospital.hms.dto.PatientResponseDto;
import com.hospital.hms.entity.Patient;
import com.hospital.hms.exception.AlreadyExistsException;
import com.hospital.hms.mapper.PatientMapper;
import com.hospital.hms.repository.PatientRepository;
import com.hospital.hms.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;


    @Override
    public PatientResponseDto addNewPatient(PatientRequestDto requestDto) {
        if (patientRepository.existsByEmail(requestDto.getEmail())) {
            throw new AlreadyExistsException("Email already exists: " + requestDto.getEmail());
        }
        if (patientRepository.existsByPhone(requestDto.getPhone())) {
            throw new AlreadyExistsException("Phone number already exists: " + requestDto.getPhone());
        }



        Patient patient = patientMapper.toPatientEntity(requestDto);
        Patient savedPatient = patientRepository.save(patient);
        return patientMapper.toPatientResponseDto(savedPatient);
    }

    @Override
    public List<PatientResponseDto> getAllPatient() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(patientMapper::toPatientResponseDto)
                .collect(Collectors.toList());
    }
}
