package com.iss.springboot.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.annotation.Async;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private int id;
    private String name;
    private double fees;
    // when we are using the lombok we dont have to write the getters and setters
    // the spring will handle all for us
    // you know about the builder pattern
    // all these annotation are required for a pojo object
}
