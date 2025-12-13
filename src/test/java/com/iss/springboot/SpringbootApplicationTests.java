package com.iss.springboot;

import com.iss.springboot.Models.Product;
import com.iss.springboot.Services.IProductService;
import com.iss.springboot.Services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    private IProductService productService;

    @Test
    public void listProducts()
    {
//        System.out.println("listProducts");
        productService.findAll().forEach(System.out::println);
    }

    @Test
    public void saveProduct()
    {
        productService.save(Product.builder().name("lenovo").price(9000).build());
    }
}
