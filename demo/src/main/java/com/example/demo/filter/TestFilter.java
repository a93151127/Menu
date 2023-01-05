package com.example.demo.filter;

import com.example.demo.wrapper.BodyReaderHttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.stream.Collectors;

@Component
@Slf4j
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        log.info("SessionFilter start");

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        BodyReaderHttpServletRequestWrapper httpServletRequestWrapper = new BodyReaderHttpServletRequestWrapper(httpServletRequest);
        String body = httpServletRequestWrapper.getReader().lines().collect(Collectors.joining());

        log.info("body : {}", body);

        filterChain.doFilter(httpServletRequestWrapper, response);




        log.info("SessionFilter end");
    }

    @Override
    public void destroy() {
    }
}
