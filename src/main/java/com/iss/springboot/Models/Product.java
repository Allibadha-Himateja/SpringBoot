package com.iss.springboot.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(
            name = "product_seq",
            sequenceName = "product_seq",
            initialValue = 1000,
            allocationSize = 1
    )
    private int id;

    private String name;
    private double price;
}

// creating the entity after configuring the application properties with @Entity and @Id
