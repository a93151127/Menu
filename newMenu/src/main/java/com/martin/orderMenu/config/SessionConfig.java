package com.martin.orderMenu.config;


import com.martin.orderMenu.interceptor.SessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class SessionConfig  extends WebMvcConfigurerAdapter {

    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*
        使用此方法會呼叫interceptor兩次
        registry.addInterceptor(sessionInterceptor);
         */
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/main/*");
    }

}
