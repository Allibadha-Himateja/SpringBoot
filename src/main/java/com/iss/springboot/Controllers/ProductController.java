package com.iss.springboot.Controllers;

import com.iss.springboot.Models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public String index(Model model)
    {
        List<Product> products = new ArrayList<>();
        products.add(Product.builder().id(1).name("hp").price(2000).build());
        products.add(Product.builder().id(1).name("vivo").price(1000).build());
        products.add(Product.builder().id(1).name("dell").price(2500).build());
        model.addAttribute("productlist", products);
        return "productsList";
    }
}
