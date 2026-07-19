package com.SecuredEntityMappings.mapper;

import com.SecuredEntityMappings.dto.UserDTO;
import com.SecuredEntityMappings.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User user);
    User toEntity(UserDTO userDTO);


}