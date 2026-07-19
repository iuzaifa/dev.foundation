package com.coreSpringSecurity.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserPrinciples implements UserDetails {

    private final Employee employee;
    private final List<GrantedAuthority> authorities;

    // Constructor mein Employee object inject ho raha hai
    public UserPrinciples(Employee employee) {
        this.employee = employee;

        // Employee roles ko comma se split karke authority list bana rahe hain
        this.authorities = Arrays.stream(employee.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities; // Actual authorities list return karo
    }

    @Override
    public String getPassword() {
        return employee.getPassword(); // DB se password return karo
    }

    @Override
    public String getUsername() {
        return employee.getName(); // DB se username return karo
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Optional: account expire logic yahan add kar sakte ho
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Agar login attempts limit lagani hai to yahan false karo
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Optional: credential expire logic yahan add kar sakte ho
    }

    @Override
    public boolean isEnabled() {
        return true; // Agar user active/inactive toggle chahiye to yahan handle karo
    }
}
