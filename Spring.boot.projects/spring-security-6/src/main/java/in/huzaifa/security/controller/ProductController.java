package in.huzaifa.security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {

    private record Product (Integer productId, String productName, Double productPrice){}

    private List<Product> products  = new ArrayList<> (
            List.of(
                    new Product(1, "Laptop", 55000.00),
                    new Product(2, "Smartphone", 29999.00),
                    new Product(3, "Headphones", 1999.00),
                    new Product(4, "Keyboard", 999.00),
                    new Product(5, "Mouse", 799.00),
                    new Product(6, "Monitor", 12000.00),
                    new Product(7, "Smartwatch", 4999.00),
                    new Product(8, "Tablet", 18000.00),
                    new Product(9, "Speaker", 1499.00),
                    new Product(10, "Power Bank", 1299.00)
            )
    );

    @GetMapping
    public List<Product> getProducts (){
        return products;
    }

    @PostMapping
    public Product saveProduct(Product product){
        products.add(product);
        return product;
    }



    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
