package com.iss.springboot.Models.OnetoOne;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="drivers")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Driver {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,updatable = false)
    private String name;

    @OneToOne(
            // all these are the changings of default values
//            // a car will only be retrieved from the database when
//            // it is explicitly accessed
//            fetch = FetchType.LAZY,
//            // you must specify a Car before you save the Driver
//            optional = false,
//            // all save/persist operations will be propagated
//            // through to the Car
//            cascade = CascadeType.PERSIST
    )
    private Car car;
//    car_id column is created
//    This is because of:
//    @OneToOne
//    private Car car;
//    Hibernate translates this to:
//    “Driver has a foreign key referencing Car”
//    So:
//    car_id → FK column
//    Nullable (no optional = false specified) --> means we can create the Driver without the car instance

}
