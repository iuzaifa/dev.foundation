package com.example.security_example.service;

import com.example.security_example.dto.LoginRequest;
import com.example.security_example.dto.LoginResponse;
import com.example.security_example.dto.SignupRequest;
import com.example.security_example.dto.SignupResponse;
import com.example.security_example.entity.User;
import com.example.security_example.repository.UserRepository;
import com.example.security_example.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class AuthService {


    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;



    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );
        User user = (User) authentication.getPrincipal();
        String jwtToken = jwtUtil.generateToken(user);
        return new LoginResponse(user.getEmail(), jwtToken);
    }


    public SignupResponse signup(SignupRequest signupRequest) {
        // Check if email already exists
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            throw new RuntimeException("Email Already Exists");
        }

        // Build User object
        User user = User.builder()
                .email(signupRequest.getEmail())
                .password(encoder.encode(signupRequest.getPassword()))
                .address(signupRequest.getAddress())
                .build();

        userRepository.save(user);

        // Build response object
        return SignupResponse.builder()
                .userID(user.getUserID())
                .email(user.getEmail())
                .password(user.getPassword())
                .address(user.getAddress())
                .build();
    }
}
