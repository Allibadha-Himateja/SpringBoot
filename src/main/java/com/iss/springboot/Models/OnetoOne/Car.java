package com.iss.springboot.Models.OnetoOne;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // what is the difference between the GenerationType.AUTO  and GenerationType.IDENTITY
    // AUTO tell the persistance provide(hibernate) to choose any optimal statergy for primary key generation which is SEQUENCE IN MOST DB's
    // IDENTITY IS LIKE CREATING THE AUTO_INCREMENT type in generating primary key values
    private Long id;

    @Column(nullable = false)
    private String brand;

    @Column(name = "horsepower")
    private int horsepower;

    /// this below annotation represents the bidirectional relationship
//    @OneToOne(
//            // indicates that this is the child side of a
//            // relationship and refers to the field in the Driver
//            // class that defines the relationship there
//            mappedBy = "car"
//    )
//    private Driver driver;
}
