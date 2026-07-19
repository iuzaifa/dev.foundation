package com.SecuredEntityMappings.dto;

import com.SecuredEntityMappings.model.UserProfile;
import lombok.Data;

@Data
public class UserDTO {




    private Long id;
    private String username;
    private String userEmail;
    private String password;
    private UserProfileDTO userProfile;
}
