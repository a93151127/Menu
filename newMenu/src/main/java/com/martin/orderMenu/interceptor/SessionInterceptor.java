package com.martin.orderMenu.interceptor;
import com.martin.orderMenu.exception.OPException;
import com.martin.orderMenu.util.JsonUtil;
import com.martin.orderMenu.model.SuperRequest;
import com.martin.orderMenu.model.SuperRequest.Header;
import com.martin.orderMenu.requestWrapper.BodyReaderHttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.stream.Collectors;

@Slf4j
@Component
public class SessionInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("httpReq.getRequestURI(): {}", request.getRequestURI());
        log.info("preHandle start");

        try{
            HttpSession session = request.getSession();
            log.info("SI preHandle servlet id : {}", session.getId());

            Header header = getEntry(request);

            if(header == null){
                throw new Exception("沒有Header");
            }
            log.info("SI preHandle Header id : {}", header.getSession_id());
        }catch(OPException op){
            log.info("sessionInterceptor OPException error: {}", op);
            request.setAttribute("Exception", op);
            request.getRequestDispatcher("/error/error00").forward(request, response);
            return false;
        }catch(Exception e){
            log.info("sessionInterceptor error: {}", e);
            request.setAttribute("Exception", e);
            request.getRequestDispatcher("/error/error00").forward(request, response);
            return false;
        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle start");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private Header getEntry(HttpServletRequest request) throws IOException {

        HttpServletRequest httpReq = (HttpServletRequest) request;
        BodyReaderHttpServletRequestWrapper httpServletRequestWrapper = new BodyReaderHttpServletRequestWrapper(httpReq);
        String body = httpServletRequestWrapper.getReader().lines().collect(Collectors.joining());

        SuperRequest superReq = new SuperRequest();
        log.info("body.toString(): {} ", body.toString());
        superReq = (SuperRequest) JsonUtil.jsonToObject(body.toString(), superReq);
        log.info("superReq: {} ", superReq);

        if(superReq.getHeader() == null){
            return null;
        }

        return superReq.getHeader();
    }
}