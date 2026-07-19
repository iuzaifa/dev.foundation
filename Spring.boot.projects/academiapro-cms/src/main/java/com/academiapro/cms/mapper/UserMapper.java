package com.academiapro.cms.mapper;

import com.academiapro.cms.dto.RegisterRequest;
import com.academiapro.cms.entiy.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {


    User toRegisterEntity(RegisterRequest registerRequest);
    RegisterRequest toRegisterDto(User user);





}
