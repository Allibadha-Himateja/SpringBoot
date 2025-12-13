package com.iss.springboot.Services;

import com.iss.springboot.Models.Product;
import com.iss.springboot.Repositories.IProductRepository;

import java.util.List;

public class ProductService implements IProductService
{

    private IProductRepository productRepository;
    public void setProductRepository(IProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
