package com.springsecurity_javatechie.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {


    private int productId;
    private String name;
    private Long qty;
    private Long price;


}
