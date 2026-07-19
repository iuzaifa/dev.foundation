package com.login_Application.loginApp.services;

import com.login_Application.loginApp.entities.User;
import com.login_Application.loginApp.exceptions.LoginResult;
import com.login_Application.loginApp.payload.UserLoginDTO;
import com.login_Application.loginApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User createUser(User user) {
//        User savedUser = userRepo.save(user);
        return userRepo.save(user);
    }

    public String loginUser(UserLoginDTO userLoginDTO) throws LoginResult {
        if (userLoginDTO.getEmail().isEmpty() || userLoginDTO.getPassword().isEmpty()) {
            throw new RuntimeException("Empty Fields not allowed");
        }
        User user = userRepo.findByEmail(userLoginDTO.getEmail());
        if(user == null){
            throw new RuntimeException("User does not exist");
        }

        if(userLoginDTO.getPassword().equals(user.getPassword())){
            return "Login Success";
        } else {
            return "Incorrect Password";
        }

//        if (email.contentEquals(email) && password.contentEquals(password)){
//
//            if (email.contentEquals(email) || password.isEmpty()){
//                throw new LoginResult("Password does not match with user, Password = " + password);
//            }
//            return loginUser(email, password);
//
//        }else {
//            return loginUser(email, password);
//        }
    }


}
