package com.martin.orderMenu.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Slf4j
public class SessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        log.info("SessionFilter start");
        long startTime = System.currentTimeMillis();
        HttpServletRequest httpReq = (HttpServletRequest) request;

        filterChain.doFilter(request, response);

        long endTime = System.currentTimeMillis();
        log.info("SessionFilter end");
    }

    @Override
    public void destroy() {
    }
}
