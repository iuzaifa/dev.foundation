package com.education.eduadmin.mapper;

import com.education.eduadmin.dto.guardian.GuardianRequestDto;
import com.education.eduadmin.dto.guardian.GuardianResponseDto;
import com.education.eduadmin.entity.Guardian;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;

@Mapper(componentModel = "spring")
public interface GuardianMapper {

    Guardian toEntity (GuardianRequestDto requestDto);
    GuardianResponseDto toDto(Guardian guardian);
}
