package com.springsecurity_example.config;

import com.springsecurity_example.entities.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeInfoDetails implements UserDetails {


    private String email;
    private String password;
    private List<GrantedAuthority> authorities;
    private Employee employee;

    public EmployeeInfoDetails(Employee employee) {
        this.employee = employee;
        this.email = employee.getEmail();
        this.password = employee.getPassword();
        this.authorities = Arrays.stream(employee.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
