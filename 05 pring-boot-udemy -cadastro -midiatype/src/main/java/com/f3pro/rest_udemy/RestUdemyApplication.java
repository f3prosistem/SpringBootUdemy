package com.f3pro.rest_udemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class RestUdemyApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestUdemyApplication.class, args);
    }

}
