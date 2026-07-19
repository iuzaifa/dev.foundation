package com.coreSpringSecurity.mapper;

import com.coreSpringSecurity.dto.RolesDTO;
import com.coreSpringSecurity.model.Roles;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface RolesMapper {

    Roles toEntity (RolesDTO rolesDTO);

    RolesDTO toDto(Roles roles);
}
