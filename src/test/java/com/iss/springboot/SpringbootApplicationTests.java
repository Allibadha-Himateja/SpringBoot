package com.iss.springboot;

import com.iss.springboot.Models.Category;
import com.iss.springboot.Models.Product;
import com.iss.springboot.Repositories.ICategoryRepository;
import com.iss.springboot.Services.IProductService;
import com.iss.springboot.Services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    private IProductService productService;

    @Autowired
    ICategoryRepository categoryRepository;

    @Test
    public void listProducts()
    {
//        System.out.println("listProducts");
        productService.findAll().forEach(System.out::println);
    }

    @Test
    public void saveProduct()
    {
        Category category = Category.builder().id(1).name("Electronics").build();
        categoryRepository.save(category);

        productService.save(Product.builder().name("hp").price(10000).category(category).build());
        productService.save(Product.builder().name("lenovo").price(9000).category(category).build());
        productService.save(Product.builder().name("dell").price(12000).category(category).build());
    }
}
