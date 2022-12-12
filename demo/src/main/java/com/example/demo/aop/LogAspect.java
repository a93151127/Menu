package com.example.demo.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
//@Slf4j
public class LogAspect {
	
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
		//log.info("before mapping");
	}
	@AfterReturning(
			pointcut = "within(@org.springframework.web.bind.annotation.RequestMapping *)",
			returning = "result")

	public void afterRequestMapping(JoinPoint jp, Object result){

		}
		
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

