package com.example.ecommerce.service.product;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.request.AddProductRequest;
import com.example.ecommerce.request.ProductUpdateRequest;

import java.util.List;

public interface IProductService {

    // ======================== Product CRUD ========================

    Product addProduct (AddProductRequest request);
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product updateProductById(Long id, ProductUpdateRequest request);
    void deleteProductById(Long id);



    // ======================== Product Queries ========================

    List<Product> getProductByName(String name);
    List<Product> getProductByCategory(String category);
    List<Product> getProductByBrand(String brand);
    List<Product> getProductByCategoryAndBrand(String category, String brand);
    List<Product> getProductByBrandAndName(String brand, String name);



    // ======================== Utilities ========================

    // Count products by brand and name
    Long countProductByBrandAndName(String brand , String  name);





}
