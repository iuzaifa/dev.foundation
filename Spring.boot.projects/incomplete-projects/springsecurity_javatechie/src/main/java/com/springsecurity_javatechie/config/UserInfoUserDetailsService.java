package com.springsecurity_javatechie.config;

import com.springsecurity_javatechie.entities.UserInfo;
import com.springsecurity_javatechie.repositories.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;




    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//        Optional<UserInfo> userInfo = userInfoRepository.findByName(name);
//
//
//        return userInfo.map(user -> new UserInfoUserDetail(user))
//                .orElseThrow(()-> new UsernameNotFoundException("user not found "+ name));

        Optional<UserInfo> userInfo = userInfoRepository.findByName(name);
        if (userInfo.isPresent()) {
            // User found, return a UserInfoUserDetail with the userInfo object
            return new UserInfoUserDetail(userInfo.get());  // Return a UserDetails object with userInfo
        } else {
            // User not found, throw exception
            throw new UsernameNotFoundException("User not found: " + name);
        }

    }


}
