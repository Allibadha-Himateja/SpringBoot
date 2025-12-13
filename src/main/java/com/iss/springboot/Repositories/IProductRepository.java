package com.iss.springboot.Repositories;

import com.iss.springboot.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Integer>
{

}
