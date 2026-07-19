package com.SecuredEntityMappings.service;

import com.SecuredEntityMappings.dto.UserDTO;
import com.SecuredEntityMappings.exception.ResourceNotFoundException;
import com.SecuredEntityMappings.mapper.UserMapper;
import com.SecuredEntityMappings.model.User;
import com.SecuredEntityMappings.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    public UserDTO findById(Integer userid) {
        return userMapper.toDto(userRepository.findById(userid)
                .orElseThrow(()-> new RuntimeException( "User not found")));
    }


}
