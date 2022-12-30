package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.application.Student;
import com.example.demo.application.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class testController {

    @RequestMapping("/jyquery")
    @ResponseBody
    public String inputCentreRequest(HttpServletRequest request,HttpServletResponse res) {
        return "成功";

    }
}
