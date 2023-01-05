package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.application.Student;
import com.example.demo.application.Test;
import com.example.demo.exception.OPException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
@Slf4j
public class testController {

    @RequestMapping("/jyquery")
    @ResponseBody
    public String inputCentreRequest(HttpServletRequest request,HttpServletResponse res) throws OPException {
        Student s = new Student();
        try{
            s.getExc();
        }catch(OPException op){
            throw op;
        }
        return "成功";

//        log.info("bindingResult : {}", bindingResult);
//        log.info("bindingResult.toString() : {}", bindingResult.toString());
//
//        if(s == null){
//            return "成功";
//        }else{
//            throw new OPException("123", "ABC", bindingResult);
//        }

    }
}
