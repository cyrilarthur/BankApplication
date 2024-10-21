package com.example.demo.Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
@EnableJpaRepositories(basePackages = "com.example.demo.Repositories")
@RestController
public class BankAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankAppApplication.class, args);
    }

//    @GetMapping
//    public  String hello(){
//        return "hello world";
//    }
//}
}
