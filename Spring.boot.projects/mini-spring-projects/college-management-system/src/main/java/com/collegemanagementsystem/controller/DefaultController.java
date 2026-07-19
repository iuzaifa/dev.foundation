package com.collegemanagementsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {



    @GetMapping("/")
    public String DefaultMessage(){
       return "Hello Default Page";
    }
}
