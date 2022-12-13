package com.martin.orderMenu.interceptor;
import com.martin.orderMenu.jsonUtil.JsonUtil;
import com.martin.orderMenu.model.SuperRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.martin.orderMenu.model.SuperRequest.Header;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Locale;

@Slf4j
public class SessionInterceptor extends HandlerInterceptorAdapter{

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws IOException {
        log.info("interceptor start");
        Locale.setDefault(Locale.TAIWAN);
        HttpSession session = request.getSession();
        log.info("preHandle servlet id : {}", session.getId());

        Header header = getEntry(request);
        return true;
    }

    private Header getEntry(HttpServletRequest request) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = null;
        SuperRequest superRequest = new SuperRequest();

        try {
            reader = request.getReader();

            for(String line = reader.readLine(); line !=null; line = reader.readLine()){
                sb.append(line);
            }
            superRequest = (SuperRequest) JsonUtil.jsonToObject(sb.toString(), superRequest);
            log.info("json request : {}", superRequest);

            if(superRequest.getHeader() == null){
                return null;
            }
        } finally  {
            if(reader != null){
                reader.close();
            }
        }
        return superRequest.getHeader();
    }
}
