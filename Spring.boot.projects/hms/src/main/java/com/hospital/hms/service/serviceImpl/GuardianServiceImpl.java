package com.hospital.hms.service.serviceImpl;

import com.hospital.hms.dto.GuardianRequestDto;
import com.hospital.hms.dto.GuardianResponseDto;
import com.hospital.hms.entity.Guardian;
import com.hospital.hms.entity.Patient;
import com.hospital.hms.exception.ResourceNotFoundException;
import com.hospital.hms.mapper.GuardianMapper;
import com.hospital.hms.mapper.PatientMapper;
import com.hospital.hms.repository.GuardianRepository;
import com.hospital.hms.repository.PatientRepository;
import com.hospital.hms.service.GuardianService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GuardianServiceImpl implements GuardianService {

    private final PatientRepository patientRepository;
    private final GuardianRepository guardianRepository;

    private final GuardianMapper guardianMapper;
    private final PatientMapper patientMapper;


    @Override
    public GuardianResponseDto addGuardian(Long patientId, GuardianRequestDto requestDto) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(()->
                new ResourceNotFoundException("Patient not found with ID: "+ patientId));
        Guardian guardian = guardianMapper.toGuardianEntity(requestDto);
        guardian.getPatients().add(patient);
        Guardian savedGuardian = guardianRepository.save(guardian);
        return guardianMapper.toGuardianResponse(savedGuardian);
    }

    @Override
    public List<GuardianResponseDto> getAllGuardians() {
        List<Guardian>  guardians = guardianRepository.findAll();
        return guardians.stream().map(guardianMapper::toGuardianResponse)
                .collect(Collectors.toList());
    }
}
