package com.login_Application.loginApp.controllers;

import com.login_Application.loginApp.entities.User;
import com.login_Application.loginApp.payload.UserLoginDTO;
import com.login_Application.loginApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//@RequestMapping("/login-app") // RequestMapping use for default api
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/get-user-by-password")
    public String loginUser (@RequestBody UserLoginDTO userLoginDTO){
        return userService.loginUser(userLoginDTO);
    }
}
