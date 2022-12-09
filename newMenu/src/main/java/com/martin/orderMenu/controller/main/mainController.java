package com.martin.orderMenu.controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.martin.orderMenu.model.SuperController;
import com.martin.orderMenu.model.SuperRequest;
//import com.martin.orderMenu.model.SuperResponse;
import com.martin.orderMenu.model.main.MainRequest;
//import com.martin.orderMenu.model.main.MainResponse;

@RestController
@RequestMapping(value = "/main")
//public class mainController extends SuperController{
public class mainController{
	
//	@RequestMapping(value = "/firstApi", method = RequestMethod.POST)
//	public MainResponse firstApi(@RequestBody MainRequest model, HttpServletRequest req,
//			HttpServletResponse res) throws JsonProcessingException {
//		SuperRequest.Header reqH = model.getHeader();
//		SuperResponse.Header resH = this.getResponseHeader("M001",reqH);
//		MainResponse.Body resB = new MainResponse.Body("beef rice");
//		
//		return new MainResponse(resH, resB);
//	}
	
	@RequestMapping(value = "/firstApi", method = RequestMethod.POST)
	public MainRequest firstApi(@RequestBody MainRequest model, HttpServletRequest req,
			HttpServletResponse res) throws JsonProcessingException {
		SuperRequest.Header reqH = model.getHeader();
//		SuperResponse.Header resH = this.getResponseHeader("M001",reqH);
//		MainResponse.Body resB = new MainResponse.Body("beef rice");
		
		return model;
	}
}
