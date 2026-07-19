package com.SecuredEntityMappings.service;

import com.SecuredEntityMappings.dto.UserProfileDTO;

public interface UserProfileService {


    UserProfileDTO createProfile (Integer userId, UserProfileDTO userProfileDTO);

}
