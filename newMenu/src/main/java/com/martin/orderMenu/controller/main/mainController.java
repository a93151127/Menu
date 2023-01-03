package com.martin.orderMenu.controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.martin.orderMenu.model.user.UserDetailRequest;
import com.martin.orderMenu.model.user.UserDetailResponse;
import com.martin.orderMenu.model.user.UserRankRequest;
import com.martin.orderMenu.model.user.UserRankResponse;
import com.martin.orderMenu.service.userDetail.UserDetailService;
import com.martin.orderMenu.service.userRank.UserRankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.martin.orderMenu.model.SuperController;
import com.martin.orderMenu.model.SuperRequest;
import com.martin.orderMenu.model.SuperResponse;
import com.martin.orderMenu.model.main.MainRequest;
import com.martin.orderMenu.model.main.MainResponse;

@Slf4j
@RestController
@RequestMapping(value = "/main")
public class mainController extends SuperController{
//public class mainController{

	@Autowired
	private UserRankService userRankService;

	@Autowired
	private UserDetailService userDetailService;
	
	@RequestMapping(value = "/firstApi", method = RequestMethod.POST)
	public MainResponse firstApi(@RequestBody MainRequest model, HttpServletRequest req,
								 HttpServletResponse res) throws JsonProcessingException {
		SuperRequest.Header reqH = model.getHeader();
		String sessionId = req.getSession().getId();
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

	@RequestMapping(value = "/createUserRank", method = RequestMethod.POST)
	public UserRankResponse createUserRank(@RequestBody UserRankRequest model, HttpServletRequest req,
										   HttpServletResponse res) throws JsonProcessingException {

		SuperRequest.Header reqH = model.getHeader();
		log.info("req.getSession : {}", req.getSession().getId());
		try {
			this.checkSessionId(model, req);
			userRankService.insertUserRank(model.getBody(), reqH);

			SuperResponse.Header resH = this.getResponseHeader("M000",reqH);
			UserRankResponse.Body resB = new UserRankResponse.Body("成功");

			return new UserRankResponse(resH, resB);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@RequestMapping(value = "/createUserDetail", method = RequestMethod.POST)
	public UserDetailResponse createUserDetail(@RequestBody UserDetailRequest model, HttpServletRequest req,
											   HttpServletResponse res) throws JsonProcessingException {

		SuperRequest.Header reqH = model.getHeader();
		log.info("req.getSession : {}", req.getSession().getId());
		try {
			this.checkSessionId(model, req);
			userDetailService.insertUserDetail(model.getBody(), reqH);

			SuperResponse.Header resH = this.getResponseHeader("M000",reqH);
			UserRankResponse.Body resB = new UserRankResponse.Body("成功");

			return new UserDetailResponse(resH, resB);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
