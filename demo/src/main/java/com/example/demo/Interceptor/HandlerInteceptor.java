package com.example.demo.Interceptor;

import aesUtil.AESUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.reader.HttpServletRequestReader;
import com.example.demo.wrapper.BodyReaderHttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.Collectors;

@Component
@Slf4j
public class HandlerInteceptor extends HandlerInterceptorAdapter {

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        System.out.println("請求結束");
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        System.out.println("controller完成之後");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse res, Object arg2) throws Exception {
        log.info("httpReq.getRequestURI(): {}", request.getRequestURI());

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletRequestWrapper httpServletRequestWrapper = new HttpServletRequestWrapper(httpServletRequest);
        String body = httpServletRequestWrapper.getReader().lines().collect(Collectors.joining());
        String bodyrequest = request.getReader().lines().collect(Collectors.joining());

        log.info("inside interceptor body : {}", body);
        log.info("inside interceptor bodyrequest : {}", bodyrequest);



        return true;
    }


}
