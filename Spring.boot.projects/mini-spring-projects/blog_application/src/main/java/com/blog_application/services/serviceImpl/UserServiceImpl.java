package com.blog_application.services.serviceImpl;


import com.blog_application.Exceptions.ResourceNotFoundException;
import com.blog_application.Repositories.UserRepository;
import com.blog_application.entities.User;
import com.blog_application.payloads.UserDto;
import com.blog_application.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Create a new user
    public UserDto createUser(UserDto userDto) {
        // Convert UserDto to User entity
        User user = modelMapper.map(userDto, User.class);
        // Save the user entity
        User savedUser = userRepository.save(user);
        // Convert the saved User entity back to UserDto
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, int userId) {
        return null;
    }

//    @Override
    public UserDto updateUser(UserDto userDto, int userId) {
        // Find the user by ID or throw an exception if not found
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        // Update the user entity with the data from the DTO
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());
        // Save the updated user entity
        User updatedUser = userRepository.save(user);
        // Map the updated user entity back to a DTO
        return modelMapper.map(updatedUser, UserDto.class);
    }


    // Get a user by ID
    public UserDto getUserById(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        // Convert User entity to UserDto
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        // Fetch all users from the database
        List<User> users = userRepository.findAll();
        // Map each User entity to a UserDto using ModelMapper
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        userRepository.delete(user);
    }
}