package com.academiapro.cms.controller;

import com.academiapro.cms.config.CustomUserDetailsService;
import com.academiapro.cms.constants.ApiConstants;
import com.academiapro.cms.dto.LoginRequest;
import com.academiapro.cms.dto.RegisterRequest;
import com.academiapro.cms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping()
@RequiredArgsConstructor
@RestController
public class AuthenticationController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailService;

    @PostMapping(ApiConstants.REGISTER) // => /register
    public ResponseEntity<?> register (@RequestBody RegisterRequest register){
        return  new ResponseEntity<>(userService.register(register), HttpStatus.CREATED);
    }

    @PostMapping(ApiConstants.LOGIN)
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                        loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        List<String> roles = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

//        userDetailService.loadUserByUsername()

        return null;
    }

}
