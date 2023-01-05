package com.example.demo.config;

import com.example.demo.Interceptor.HandlerInteceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@org.springframework.context.annotation.Configuration
public class Configuration extends WebMvcConfigurerAdapter {

    @Autowired
    private HandlerInteceptor handlerInteceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInteceptor()).addPathPatterns("/test/*");
//        registry.addInterceptor(handlerInteceptor);
    }
}
