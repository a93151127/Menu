package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public Object sayHello(String name, String age) {
//        System.out.println("name: " + name);
//        System.out.println("age: " + age);
        return "hello " + name + "age " + age;
    }
}
