package com.academiapro.cms.service.serviceImpl;
import com.academiapro.cms.dto.LoginRequest;
import com.academiapro.cms.dto.RegisterRequest;
import com.academiapro.cms.entiy.User;
import com.academiapro.cms.exception.ResourceAlreadyExistsException;
import com.academiapro.cms.mapper.UserMapper;
import com.academiapro.cms.repository.UserRepository;
import com.academiapro.cms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(14);

    @Override
    @Transactional
    public RegisterRequest register(RegisterRequest registerRequest) {
        // 1. CHECK EXISTENCE FIRST
        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new ResourceAlreadyExistsException(
                    "User already exists with email: " + registerRequest.getEmail()
            );
        }
        if (userRepository.existsByPhone(registerRequest.getPhone())) {
            throw new ResourceAlreadyExistsException(
                    "User already exists with phone: " + registerRequest.getPhone()
            );
        }
        User user = userMapper.toRegisterEntity(registerRequest);
        user.setPassword(encoder.encode(registerRequest.getPassword()));
        // 4. GENERATE USERNAME BEFORE SAVING
        user.setUsername(getUniqueUsername(registerRequest.getFirstname(), registerRequest.getLastname()));
        user.setActive(true);
        User savedUser = userRepository.save(user);
        return userMapper.toRegisterDto(savedUser);
    }

    @Override
    public String login(LoginRequest loginRequest) {
        return "success";
    }

    public String generateUsername(String firstname, String lastname) {
        String fn = firstname.toLowerCase().replaceAll("[^a-z0-9]", "");
        String ln = lastname.toLowerCase().replaceAll("[^a-z0-9]", "");
        String[] patterns = {
                fn + "_" + ln,           // abu_usama
                fn + "." + ln,           // abu.usama
                ln + "_" + fn,           // usama_abu
                fn + ln,                 // abuusama
                fn + "_" + ln + "_" + (int)(Math.random() * 99) // abu_usama_72
        };
        // Pick a random pattern from the list for the first attempt
        return patterns[(int) (Math.random() * patterns.length)];
    }

    @Transactional
    public String getUniqueUsername(String firstname, String lastname) {
        String username = generateUsername(firstname, lastname);
        int attempts = 0;
        while (userRepository.existsByUsername(username)) {
            attempts++;
            if (attempts < 5) {
                // Try another stylish pattern
                username = generateUsername(firstname, lastname);
            } else {
                username = firstname.toLowerCase() + "_" + lastname.toLowerCase() + System.currentTimeMillis() % 10000;
            }
        }
        return username;
    }


}
