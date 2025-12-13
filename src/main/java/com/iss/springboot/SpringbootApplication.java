package com.iss.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
    // this is the initial file which is provided to you from the spring intializer
    // this class defines as the @SpringBootApplication
    // which is equivalent to the
    // @ComponentScan,
    // @EnableAutoConfiguaration,
    // @Configuration
    // these three annotations are crucial for the springboot application
    // when we create a springboot application we will handle multiple files
    // those important setup files for any springboot application are
    // pom.xml, application.properties, configuration class which will hold bean definations
    // resource folder or webapp folder when we are using the jsp templates ....

    // all these factors are crucial and mandatory for any springboot application to work.

    // we will start the springboot with springboot MVC ARCHITECTURE
    //  MVC ARCHITECHTURE IS A MONOLITIC ARCHITECTURE WHICH INVOLVES HANDLING OF centralized system which is
    // a server which will react and respond to all the incoming requests

    // this mvc architecture is constructed in three layers
    // models which are also called pojo class (plain old java object)
    // views which are the user interface provided by templates such as jsp or html
    // controllers the controller are the functionality handler which involves managing the incoming request based
    // on actions and url mapping it involves business logic


}
