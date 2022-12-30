package com.example.demo;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws Exception {
//        boolean a = false;
//        try {
//            if(new Student().getBoolean("0")){
//                System.out.println("a");
//            }
//        } catch(Exception e){
//            System.out.println("bbb");
//            throw new Exception(e.getMessage());
//        }finally {
//                System.out.println("aaaaaaaa");
//            }
//
//        System.out.println("abc");
        SpringApplication.run(DemoApplication.class, args);
    }

}

class Student{

    public boolean getBoolean(String abc) throws Exception {
        boolean result = false;
        if(abc.equals("1")){
            result = true;
        }else{
            throw new Exception("123");
        }
        return result;
    }
}