package com.example.demo.aop;

import com.example.demo.exception.OPException;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Aspect
@Component
@Slf4j
public class LogAspect {
	


	
	/*
	 * 設置切入點
	 * 定義執行完LogTestApi裡面的log方法時會進入這個method檢查有沒有需要執行的地方
	 * 括號裡面的(..)表示不管參數
	 */
	@Pointcut("execution(* com.example.demo.controller.testController.*(..))")
	public void requestMapping() {
	}
	
	/*
	 * 在log方法執行之前先進入下面這個方法
	 * 這裡也可以寫成
	 * @Before("execution(* com.martin.controller.LogTestApi.log(..))")
	 */
	@Before("requestMapping()")
	public void requestMapping(JoinPoint joinPoint) throws JsonProcessingException, OPException {
		System.out.println("Start AOP Before");

	}
	@AfterReturning(
			pointcut = "within(@org.springframework.web.bind.annotation.RequestMapping *)",
			returning = "result")
	public void afterRequestMapping(JoinPoint jp, Object result) throws JsonProcessingException, OPException {
		log.info("result : {}", result);
		System.out.println("AOP End");
	}
}
