package com.iss.springboot.Services;

import com.iss.springboot.Models.Product;

import java.util.List;

public interface IProductService {

    void save(Product product);
    Product findById(Integer id);
    List<Product> findAll();

}
