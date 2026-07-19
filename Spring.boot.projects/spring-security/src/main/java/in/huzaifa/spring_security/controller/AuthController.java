package in.huzaifa.spring_security.controller;


import in.huzaifa.spring_security.dto.AuthRequest;
import in.huzaifa.spring_security.dto.AuthResponse;
import in.huzaifa.spring_security.dto.RegisterRequest;
import in.huzaifa.spring_security.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        log.info("Register request received for username: {}", registerRequest.getEmail());
        authService.register(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Registration successfully..!");
    }


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticateUser(@Valid @RequestBody
                                                             AuthRequest authRequest) {
        log.info("Login request received for username: {}", authRequest.getEmail());
        AuthResponse response = authService.authenticate(authRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refreshToken(@RequestHeader("Authorization") String refreshToken) {
        log.info("Refresh token request received");
        AuthResponse response = authService.refreshToken(refreshToken);

        log.info(response.getFirstName() + " : " + response.getLastName());
        return ResponseEntity.ok(response);
    }


    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(HttpServletRequest request) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("Logout request received for user: {}", username);

        SecurityContextHolder.clearContext();
        return ResponseEntity.ok("Logout Success");
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validateToken() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        log.debug("Token validation request for user: {}", username);
        return ResponseEntity.ok("success");
    }

}
