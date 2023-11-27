package com.poly.truongnvph29176;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Truongnvph29176Application {

    @GetMapping("/welcome")
    public String welcome() {
        return "Spring Boot Docker Demo";
    }

    public static void main(String[] args) {
        SpringApplication.run(Truongnvph29176Application.class, args);
    }

}
