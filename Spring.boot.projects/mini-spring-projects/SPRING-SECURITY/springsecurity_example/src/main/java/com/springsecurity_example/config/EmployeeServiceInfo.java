package com.springsecurity_example.config;

import com.springsecurity_example.entities.Employee;
import com.springsecurity_example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeeServiceInfo implements UserDetailsService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Employee> employeeEmail = employeeRepository.findByEmail(email);
        if (employeeEmail.isPresent()){
            return new EmployeeInfoDetails(employeeEmail.get());
        }else {
            throw new UsernameNotFoundException("user email not found : " + email);
        }
    }
}
