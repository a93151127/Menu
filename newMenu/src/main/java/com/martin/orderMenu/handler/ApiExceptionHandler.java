package com.martin.orderMenu.handler;


import com.martin.orderMenu.exception.OPException;
import com.martin.orderMenu.model.SuperResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    /**
     * 处理参数验证失败异常
     * @param e
     * @return
     */
    @ExceptionHandler(OPException.class)
    @ResponseBody
    public SuperResponse handleOPRequest(OPException e) {
        log.info("inside handleOPRequest");

        SuperResponse res = new SuperResponse();
        SuperResponse.Header resH = new SuperResponse.Header();
        resH.setSession_id("");
        resH.setReturn_msg(e.getOpMsg());
        res.setHeader(resH);

        e.printStackTrace();

        return res;
    }


    /**
     * 处理全局异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public SuperResponse handleException(Exception e) {
        log.info("inside handleException");

        SuperResponse res = new SuperResponse();
        SuperResponse.Header resH = new SuperResponse.Header();
        resH.setSession_id("");
        resH.setReturn_msg(e.getMessage());
        res.setHeader(resH);

        e.printStackTrace();
        return res;
    }
}
