package com.example.demo.handler;

import com.example.demo.application.Test;
import com.example.demo.exception.OPException;
import com.example.demo.resource.FieldResource;
import com.example.demo.resource.OPResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    /**
     * 处理参数验证失败异常
     * @param e
     * @return
     */
    @ExceptionHandler(OPException.class)
    @ResponseBody
    public ResponseEntity<?> handleOPRequest(OPException e) {
        Test s = new Test();
        log.info("inside handleOPRequest");
        log.info("getOpCode : {}", e.getOpCode());
        log.info("getOpMsg : {}", e.getOpMsg());
        e.printStackTrace();
        return new ResponseEntity<Object>(s, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    /**
     * 处理全局异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<?> handleException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
