package com.martin.orderMenu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.martin.orderMenu.service.log.LogService;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LogAspect {
	
	@Autowired
	private LogService logService;
	
	/*
	 * 設置切入點
	 * 定義執行完LogTestApi裡面的log方法時會進入這個method檢查有沒有需要執行的地方
	 * 括號裡面的(..)表示不管參數
	 */
	@Pointcut("within(@org.springframework.web.bind.annotation.RequestMapping *)")
	public void requestMapping() {
	}
	
	/*
	 * 在log方法執行之前先進入下面這個方法
	 * 這裡也可以寫成
	 * @Before("execution(* com.martin.controller.LogTestApi.log(..))")
	 */
	@Before("requestMapping()")
	public void requestMapping(JoinPoint joinPoint) {
		System.out.println("Start AOP Before");
		String name = joinPoint.getSignature().getName();
		log.info("requestMapping Name : {}", name);
		log.info("seqNo : {}", logService.getSeqNo());
	}
	/*
	 * 在log方法執行之前先進入下面這個方法
	 * 這裡也可以寫成
	 * @Before("execution(* com.martin.controller.LogTestApi.log(..))")
	 */
//	@After("log()")
//    public void doAfter() {
//        log.info("2=========");
//    }


//    @AfterReturning(returning = "result",pointcut = "log()")
//    public void doAtfertRturning(Object result) {
//        log.info("3=========");
//    }
}
