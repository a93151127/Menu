package com.martin.orderMenu.controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.martin.orderMenu.model.SuperController;
import com.martin.orderMenu.model.SuperRequest;
import com.martin.orderMenu.model.SuperResponse;
import com.martin.orderMenu.model.SuperResponse;
import com.martin.orderMenu.model.main.MainRequest;
import com.martin.orderMenu.model.main.MainResponse;
//import com.martin.orderMenu.model.main.MainResponse;

@Slf4j
@RestController
@RequestMapping(value = "/main")
public class mainController extends SuperController{
//public class mainController{
	
	@RequestMapping(value = "/firstApi", method = RequestMethod.POST)
	public MainResponse firstApi(@RequestBody MainRequest model, HttpServletRequest req,
								 HttpServletResponse res) throws JsonProcessingException {
		SuperRequest.Header reqH = model.getHeader();
		HttpSession session = req.getSession();
		log.info("req.getSession : {}", req.getSession().getId());
		try {
			this.checkSessionId(model, req);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		SuperResponse.Header resH = this.getResponseHeader("M000",reqH);
		MainResponse.Body resB = new MainResponse.Body("beef rice");
		
		return new MainResponse(resH, resB);
	}
	
}
