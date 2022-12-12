package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/test")
public class DemoController {

    @RequestMapping(value = "/aop")
    public String testAop(){
        return "hello aop";
    }
}
