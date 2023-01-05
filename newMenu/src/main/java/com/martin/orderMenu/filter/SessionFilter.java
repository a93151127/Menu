package com.martin.orderMenu.filter;

import com.martin.orderMenu.requestWrapper.BodyReaderHttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

@Component
@Slf4j
public class SessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
            log.info("SessionFilter start");

            BodyReaderHttpServletRequestWrapper httpServletRequestWrapper = new BodyReaderHttpServletRequestWrapper(httpReq);
            String body = httpServletRequestWrapper.getReader().lines().collect(Collectors.joining());

            log.info("body : {} ", body);

            filterChain.doFilter(httpServletRequestWrapper, response);

            log.info("SessionFilter end");

    }

    @Override
    public void destroy() {
    }
}
