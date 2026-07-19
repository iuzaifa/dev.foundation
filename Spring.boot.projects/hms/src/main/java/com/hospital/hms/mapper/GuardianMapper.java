package com.hospital.hms.mapper;

import com.hospital.hms.dto.GuardianRequestDto;
import com.hospital.hms.dto.GuardianResponseDto;
import com.hospital.hms.entity.Guardian;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GuardianMapper {

    // To Guardian Entity
    Guardian toGuardianEntity (GuardianRequestDto guardianRequestDto);

    // to Guardian response
    GuardianResponseDto toGuardianResponse(Guardian guardian);
}
