package com.SecuredEntityMappings.service;

import com.SecuredEntityMappings.dto.UserProfileDTO;
import com.SecuredEntityMappings.exception.ResourceNotFoundException;
import com.SecuredEntityMappings.mapper.UserprofileMapper;
import com.SecuredEntityMappings.model.User;
import com.SecuredEntityMappings.model.UserProfile;
import com.SecuredEntityMappings.repository.UserProfileRepository;
import com.SecuredEntityMappings.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService{

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserprofileMapper userprofileMapper;


    @Override
    public UserProfileDTO createProfile(Integer userId, UserProfileDTO userProfileDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        UserProfile userProfile = userprofileMapper.toEntity(userProfileDTO);
        userProfile.setUser(user);
        UserProfile savedUserProfile = userProfileRepository.save(userProfile);
        return userprofileMapper.toDto(savedUserProfile);
    }
}
