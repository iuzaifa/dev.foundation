package com.springsecurity_javatechie.services;


import com.springsecurity_javatechie.entities.Product;
import com.springsecurity_javatechie.entities.UserInfo;
import com.springsecurity_javatechie.repositories.UserInfoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    List<Product> productsList = null;

    @Autowired
    private UserInfoRepository userInfoRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @PostConstruct
    public void loadProductFromDB(){
        productsList = IntStream.range(1, 100)
                .mapToObj(i-> Product.builder()
                        .productId(i)
                        .name("Product : " + i)
                        .qty( new Random().nextLong(10))
                        .price(new Random().nextLong(500)).build()
                ).collect(Collectors.toList());
    }


    public List<Product> getProducts(){
        return productsList;
    }


    public Product getProductById(int id){
        return productsList.stream()
                .filter(product -> product.getProductId() == id)
                .findAny()
                .orElseThrow(()-> new RuntimeException( "Product Id not found : "  + id));
    }


    public UserInfo addNewUser(UserInfo userInfo){
//        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        String encodedPassword = passwordEncoder.encode(userInfo.getPassword());
        userInfo.setPassword(encodedPassword);


        return userInfoRepository.save(userInfo);
    }





}
