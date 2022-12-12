package com.martin.orderMenu.model;

import com.martin.orderMenu.model.SuperRequest;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
//import com.martin.orderMenu.model.SuperResponse;
@Slf4j
public class SuperController {

	protected void checkSessionId(SuperRequest model, HttpServletRequest req) throws Exception{
		String sessionId = model.getHeader().getSession_id();
		if(!req.getSession().getId().equals(sessionId)){
			log.info("Input SESSION_ID {} != Http Session Id {} !",
					sessionId, req.getSession().getId());
			throw new Exception("session 錯誤");
		}
	}
	
	protected SuperResponse.Header getResponseHeader(String return_code,
			SuperRequest.Header reqH){
		return getResponseHeader(return_code, null, null, reqH);
	}
	
	protected SuperResponse.Header getResponseHeader(String return_code, 
			String return_msg, String extInfo, SuperRequest.Header reqH){
		SuperResponse.Header resH = new SuperResponse.Header();
		resH.setSession_id(reqH.getSession_id()+"/res");
		
		if(return_code.equals("M000")) {
			resH.setReturn_msg("SUCESSFUL");
		}else {
			resH.setReturn_msg("FALSE");
		}
		
		return resH;
	}
}
