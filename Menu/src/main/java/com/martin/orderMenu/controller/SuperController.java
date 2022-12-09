package com.martin.orderMenu.controller;

import com.martin.orderMenu.model.SuperRequest;
import com.martin.orderMenu.model.SuperResponse;

public class SuperController {
	
	protected com.martin.orderMenu.model.Header getResponseHeader(String return_code,
			SuperRequest.Header reqH){
		return getResponseHeader(return_code, null, null, reqH);
	}
	
	protected com.martin.orderMenu.model.Header getResponseHeader(String return_code, 
			String return_msg, String extInfo, SuperRequest.Header reqH){
		SuperResponse.Header resH = new SuperResponse.Header();
		resH.setDevice_type(reqH.getDevice_type()+"/res");
		resH.setSession_id(reqH.getSession_id()+"/res");
		
		if(return_code.equals("M000")) {
			resH.setReturn_msg("SUCESSFUL");
		}else {
			resH.setReturn_msg("FALSE");
		}
		
		return resH;
	}
}
