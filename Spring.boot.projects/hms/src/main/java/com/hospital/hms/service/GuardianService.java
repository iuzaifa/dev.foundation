package com.hospital.hms.service;

import com.hospital.hms.dto.GuardianRequestDto;
import com.hospital.hms.dto.GuardianResponseDto;
import com.hospital.hms.entity.Guardian;

import java.util.List;

public interface GuardianService {


    GuardianResponseDto addGuardian(Long patientId, GuardianRequestDto requestDto);
    List<GuardianResponseDto> getAllGuardians();
}
