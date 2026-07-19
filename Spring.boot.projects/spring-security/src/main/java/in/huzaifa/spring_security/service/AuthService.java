package in.huzaifa.spring_security.service;


import in.huzaifa.spring_security.dto.AuthRequest;
import in.huzaifa.spring_security.dto.AuthResponse;
import in.huzaifa.spring_security.dto.RegisterRequest;

public interface AuthService {

    AuthResponse authenticate(AuthRequest authRequest);
    void register(RegisterRequest registerRequest);
    AuthResponse refreshToken(String refreshToken);
}