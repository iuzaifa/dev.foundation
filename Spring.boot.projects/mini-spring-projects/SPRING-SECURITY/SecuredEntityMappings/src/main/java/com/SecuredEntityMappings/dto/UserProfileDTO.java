package com.SecuredEntityMappings.dto;


import lombok.Data;

@Data
public class UserProfileDTO {

    private int id;
    private String address;
    private String phone;
    // Reference to UserDTO instead of User entity
    private UserDTO userDTO;

}
