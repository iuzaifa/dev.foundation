package com.SecuredEntityMappings.service;

import com.SecuredEntityMappings.dto.UserDTO;

public interface UserService {


    UserDTO createUser(UserDTO userDTO);

    UserDTO findById(Integer userid);


}
