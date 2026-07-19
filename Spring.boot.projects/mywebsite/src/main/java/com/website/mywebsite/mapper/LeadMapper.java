package com.website.mywebsite.mapper;

import com.website.mywebsite.dto.LeadRequestDto;
import com.website.mywebsite.dto.LeadResponseDto;
import com.website.mywebsite.entity.Lead;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeadMapper {

    Lead toLeadEntity(LeadRequestDto leadRequestDto);
    LeadResponseDto toLeadResponse(Lead lead);
}
