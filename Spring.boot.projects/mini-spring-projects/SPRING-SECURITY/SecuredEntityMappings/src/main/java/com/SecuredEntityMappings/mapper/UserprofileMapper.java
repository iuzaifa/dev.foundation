package com.SecuredEntityMappings.mapper;

import com.SecuredEntityMappings.dto.UserProfileDTO;
import com.SecuredEntityMappings.model.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserprofileMapper {

    UserProfile toEntity(UserProfileDTO dto);
    UserProfileDTO toDto(UserProfile entity);

}
