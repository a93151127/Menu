package com.martin.orderMenu.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@Component
public class SessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("start doFilter");
        HttpServletRequest httpReq = (HttpServletRequest) request;
        String servletPath = httpReq.getServletPath();
        log.info("servletPath : {}", servletPath);

        if(!servletPath.contains("main")){
            request.setAttribute("Exception", "M1000");
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

