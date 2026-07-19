package com.springsecurity_javatechie.controller;

import com.springsecurity_javatechie.dto.AuthRequest;
import com.springsecurity_javatechie.entities.UserInfo;
import com.springsecurity_javatechie.services.JWTService;
import com.springsecurity_javatechie.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {


    //  http://localhostlocalhost:8080/products/welcome
    @Autowired
    private ProductService productService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;



    @GetMapping("/welcome")
    public String welcome(){
        return "welcome to java security";
    }


    @GetMapping("/get")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> getAllProducts(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }


    @GetMapping("/get/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<?> productGetByID(@PathVariable("id") int id){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }


    @PostMapping("/addUser")
    public ResponseEntity<?> addNewUser(@RequestBody UserInfo userInfo){
        return new ResponseEntity<>(productService.addNewUser(userInfo), HttpStatus.CREATED);
    }


//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());
        }else {
            throw  new RuntimeException("invalid user request");
        }
    }

}
