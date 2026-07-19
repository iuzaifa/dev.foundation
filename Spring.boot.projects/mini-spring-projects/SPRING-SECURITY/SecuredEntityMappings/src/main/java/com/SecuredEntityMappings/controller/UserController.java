package com.SecuredEntityMappings.controller;

import com.SecuredEntityMappings.dto.UserDTO;
import com.SecuredEntityMappings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    // http://localhost:8080/user/add-user
    @PostMapping("/add-user")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
    }

    // http://localhost:8080/user/userid
    @GetMapping("/{userid}")
    public ResponseEntity<?> findById(@PathVariable Integer userid){
        return new ResponseEntity<>(userService.findById(userid), HttpStatus.OK);
    }


}
