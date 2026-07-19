package com.coreSpringSecurity.service.security;

import com.coreSpringSecurity.model.Employee;
import com.coreSpringSecurity.model.UserPrinciples;
import com.coreSpringSecurity.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Employee> employee = employeeRepository.findByUsername(username);
        return employee.map(UserPrinciples::new)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
