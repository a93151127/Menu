package com.martin.orderMenu.model;

import com.martin.orderMenu.exception.OPException;
import com.martin.orderMenu.model.SuperRequest;
import com.martin.orderMenu.vo.session.Session_VO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
//import com.martin.orderMenu.model.SuperResponse;
@Slf4j
public class SuperController {

	@Autowired
	private Session_VO sessionVo;

	protected void checkSessionId(SuperRequest model, HttpServletRequest req) throws OPException{
		String sessionId = model.getHeader().getSession_id();

		if(sessionVo.findById(sessionId) == null){
			log.info("Input SESSION_ID {} null", sessionId);
			throw new OPException("M123", "session 錯誤", "aaa");
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
