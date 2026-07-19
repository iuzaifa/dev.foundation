package com.SecuredEntityMappings.controller;

import com.SecuredEntityMappings.dto.UserProfileDTO;
import com.SecuredEntityMappings.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-profile")
public class UserProfileController {


    @Autowired
    private UserProfileService userProfileService;



    // http://localhost:8080/user-profile/add-user-profile
    @PostMapping("/add-user-profile/{userId}")
    public ResponseEntity<UserProfileDTO> createProfile(@PathVariable Integer userId, @RequestBody UserProfileDTO userProfileDTO){
        return new ResponseEntity<>(userProfileService.createProfile(userId,userProfileDTO), HttpStatus.CREATED);
    }
}
