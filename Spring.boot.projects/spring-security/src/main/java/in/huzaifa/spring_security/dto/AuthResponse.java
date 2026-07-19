package in.huzaifa.spring_security.dto;

import in.huzaifa.spring_security.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
@AllArgsConstructor
public class AuthResponse {

    private String accessToken;
    private String refreshToken;
    private String tokenType = "Bearer";
    private String email;
    private String firstName;
    private String lastName;
    private Set<Role> roles;
}
