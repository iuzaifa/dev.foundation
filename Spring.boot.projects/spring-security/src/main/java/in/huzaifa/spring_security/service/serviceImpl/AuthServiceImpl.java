package in.huzaifa.spring_security.service.serviceImpl;

import in.huzaifa.spring_security.dto.AuthRequest;
import in.huzaifa.spring_security.dto.AuthResponse;
import in.huzaifa.spring_security.dto.RegisterRequest;
import in.huzaifa.spring_security.entity.Role;
import in.huzaifa.spring_security.entity.User;
import in.huzaifa.spring_security.repository.RoleRepository;
import in.huzaifa.spring_security.repository.UserRepository;
import in.huzaifa.spring_security.service.AuthService;
import in.huzaifa.spring_security.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtTokenUtil;
    private final UserDetailsServiceImpl userDetailsService;

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        log.debug("Authenticating user: {}", authRequest.getEmail());

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getEmail(),
                            authRequest.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            User user = (User) authentication.getPrincipal();
            String jwt = jwtTokenUtil.generateToken(user);
            String refreshToken = jwtTokenUtil.generateRefreshToken(user);
            log.info("User {} authenticated successfully", user.getUsername());
            return AuthResponse.builder()
                    .accessToken(jwt)
                    .refreshToken(refreshToken)
                    .tokenType("Bearer")
                    .email(user.getEmail())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .roles(user.getRoles())
                    .build();

        } catch (BadCredentialsException e) {
            log.warn("Authentication failed for user: {}", authRequest.getEmail());
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @Override
    public void register(RegisterRequest registerRequest) {
        log.debug("Registering new user: {}", registerRequest.getEmail());
        validateRegistrationRequest(registerRequest);
        User user = createUserFromRequest(registerRequest);
        assignDefaultRole(user);
        userRepository.save(user);
        log.info("User {} registered successfully", user.getUsername());
    }

    @Override
    public AuthResponse refreshToken(String refreshToken) {
        log.debug("Refreshing token");

        if (refreshToken != null && refreshToken.startsWith("Bearer ")) {
            refreshToken = refreshToken.substring(7);
        }

        if (jwtTokenUtil.validateToken(refreshToken)) {
            String username = jwtTokenUtil.extractUsername(refreshToken);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            String newAccessToken = jwtTokenUtil.generateToken(userDetails);

            log.debug("Token refreshed for user: {}", username);

            User user = (User) userDetails;
            return AuthResponse.builder()
                    .accessToken(newAccessToken)
                    .refreshToken(refreshToken)
                    .tokenType("Bearer")
                    .email(user.getEmail())
                    .roles(user.getRoles())
                    .build();
        }

        log.warn("Invalid refresh token provided");
        throw new BadCredentialsException("Invalid refresh token");
    }

    private void validateRegistrationRequest(RegisterRequest request) {


        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email is already in use");
        }
    }

    private User createUserFromRequest(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEnabled(true);
        return user;
    }

    private void assignDefaultRole(User user) {
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseGet(() -> {
                    // Create the role if it doesn't exist
                    Role newRole = new Role("ROLE_USER");
                    newRole.setDescription("Default user role");
                    return roleRepository.save(newRole);
                });
        roles.add(userRole);
        user.setRoles(roles);
    }
}