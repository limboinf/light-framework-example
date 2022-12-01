package com.example.lightframeworkexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LightFrameworkExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(LightFrameworkExampleApplication.class, args);
    }

}
