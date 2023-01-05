package com.martin.orderMenu.controller.error;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.martin.orderMenu.codeNo.Const;
import com.martin.orderMenu.dao.log.Api_Log;
import com.martin.orderMenu.dao.log.LogHelper;
import com.martin.orderMenu.exception.OPException;
import com.martin.orderMenu.model.SuperController;
import com.martin.orderMenu.model.SuperRequest;
import com.martin.orderMenu.model.SuperResponse;
import com.martin.orderMenu.model.main.MainRequest;
import com.martin.orderMenu.model.main.MainResponse;
import com.martin.orderMenu.util.JsonUtil;
import com.martin.orderMenu.util.StringUtils;
import com.martin.orderMenu.vo.Api_Data_Log_VO;
import com.martin.orderMenu.vo.Api_Log_VO;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping(value = "/error")
public class ErrorController extends SuperController {

    @Autowired
    private Api_Log_VO apiLogVo;

    @Autowired
    private Api_Data_Log_VO apiDataLogVo;

    @RequestMapping(value = "/error00", method = RequestMethod.POST)
    public SuperResponse error00(@RequestBody SuperRequest model, HttpServletRequest req) {
        log.info("into error00");

        Exception ex = (Exception) req.getAttribute("Exception");

        if(ex != null){
            return this.getErrorResponse((OPException)ex , model);
        }else{
           String returnCode = (String) req.getAttribute("ReturnCode");
           if(returnCode == null || returnCode.equals("")){
               returnCode = "M0090";
           }
           return this.getErrorResponse(returnCode, (OPException) ex, model);
        }
    }
    private SuperResponse getErrorResponse(OPException op, SuperRequest model){
        SuperRequest.Header reqH = model.getHeader();
        SuperResponse.Header resH = getResponseHeader(op.getOpCode(), op.getOpMsg(), reqH);
        return errorLog(new SuperResponse(resH));
    }
    private SuperResponse getErrorResponse(String returnCode, OPException op, SuperRequest model){
        SuperRequest.Header reqH = model.getHeader();
        SuperResponse.Header resH = getResponseHeader(returnCode, op.getOpMsg(), reqH);
        return errorLog(new SuperResponse(resH));
    }
    private SuperResponse errorLog(SuperResponse superResponse){
        try{
            Api_Log vo = LogHelper.getLogapivo();

            if(vo != null){
                if(StringUtils.isEmpty(superResponse.getHeader().getSession_id())){
                    vo.setSession_id("");
                }else{
                    vo.setSession_id(superResponse.getHeader().getSession_id());
                }
                vo.setReturn_code(Const.FAIL);
                vo.setReturn_msg(superResponse.getHeader().getReturn_msg());

                LogHelper.insertApiLog(vo, LogHelper.getReqJson(), JsonUtil.objectToJson(superResponse),
                        apiLogVo, apiDataLogVo);
            }
        }catch(Exception e){
            log.info("errorLog error : {}", e);
        }
        return superResponse;
    }
    protected SuperResponse.Header getResponseHeader(
            String return_code, String return_msg, SuperRequest.Header reqH){
        SuperResponse.Header resH = new SuperResponse.Header();
        resH.setSession_id(reqH.getSession_id());

        if(return_code.equals("MOOO")){
            resH.setReturn_msg("SUCCESSFUL");
        }else{
            if(return_msg.equals("")){
                resH.setReturn_msg("FAIL");
            }else{
                resH.setReturn_msg(return_msg);
            }
        }
        return resH;
    }
}
