package com.example.demo.filter;

import org.springframework.core.MethodParameter;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TimeInterceptor extends HandlerInterceptorAdapter {

    private final NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<>("startTimeThreadLocal");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("time interceptor preHandle");

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 獲取處理當前請求的 handler 信息
        System.out.println("handler 類：" + handlerMethod.getBeanType().getName());
        System.out.println("handler 方法：" + handlerMethod.getMethod().getName());

        MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
        for (MethodParameter methodParameter : methodParameters) {
            String parameterName = methodParameter.getParameterName();
            // 只能獲取參數的名稱，不能獲取到參數的值
            System.out.println("parameterName: " + parameterName);
        }

        // 把當前時間放入 threadLocal
        startTimeThreadLocal.set(System.currentTimeMillis());
        //進入到Aspect
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("time interceptor postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Long startTime = startTimeThreadLocal.get();
        // 從 threadLocal 取出剛纔存入的 startTime
        long endTime = System.currentTimeMillis();

        System.out.println("time interceptor consume " + (endTime - startTime) + " ms");

        System.out.println("time interceptor afterCompletion");
    }
}
