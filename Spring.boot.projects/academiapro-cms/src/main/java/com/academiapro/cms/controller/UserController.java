package com.academiapro.cms.controller;

import com.academiapro.cms.constants.ApiConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(ApiConstants.BASE) // /api/v1
@RestController
@RequiredArgsConstructor
public class UserController {

//    private final UserService userService;
//
//    @PostMapping(ApiConstants.REGISTER) // => /register
//    private ResponseEntity<?> register (@RequestBody RegisterUser register){
//        return  new ResponseEntity<>(userService.register(register), HttpStatus.CREATED);
//    }


}
