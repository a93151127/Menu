package com.martin.orderMenu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orderMenu")
public class orderMenuController {
	
	@RequestMapping(value = "/hello")
	public String hello() {
		return "hello world";
	}
}
