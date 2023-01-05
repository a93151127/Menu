package com.martin.orderMenu.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.martin.orderMenu.dao.log.Api_Log;
import com.martin.orderMenu.dao.log.LogHelper;
import com.martin.orderMenu.exception.OPException;
import com.martin.orderMenu.util.DateUtil;
import com.martin.orderMenu.util.JsonUtil;
import com.martin.orderMenu.model.SuperRequest;
import com.martin.orderMenu.model.SuperResponse;
import com.martin.orderMenu.vo.Api_Data_Log_VO;
import com.martin.orderMenu.vo.Api_Log_VO;
import com.martin.orderMenu.vo.log.LogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.Date;

@Aspect
@Component
@Slf4j
public class LogAspect {
	
	@Autowired
	private LogService logService;

	@Autowired
	private Api_Log_VO apiLogVo;

	@Autowired
	private Api_Data_Log_VO apiDataLogVo;


	
	/*
	 * 設置切入點
	 * 定義執行完LogTestApi裡面的log方法時會進入這個method檢查有沒有需要執行的地方
	 * 括號裡面的(..)表示不管參數
	 */
	@Pointcut("execution(* com.martin.orderMenu.controller.main.mainController.*(..))")
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
		String name = joinPoint.getSignature().getName();
		try{
			String seq = logService.getSeqNo();
			Object[] signatureArgs = joinPoint.getArgs();
			String apiId = "";
			String sessionId = "";
			String reqJson = "";

			for(Object c : signatureArgs) {
				if(c instanceof SuperRequest) {
					SuperRequest sReq = (SuperRequest)c;
					com.martin.orderMenu.model.SuperRequest.Header header = sReq.getHeader();
					apiId = header.getApi_id();
					sessionId = header.getSession_id();
					reqJson = JsonUtil.objectToJson(sReq);
				}
			}

			Api_Log apiLog = new Api_Log();
			apiLog.setLog_seqno(seq);
			apiLog.setReq_time(DateUtil.qryNowTimeStamp());
			apiLog.setApi_id(apiId);
			apiLog.setSession_id(sessionId);

			LogHelper.setLogapivo(apiLog);
			LogHelper.setReqJson(reqJson);
		} catch(Exception e){
			log.info("RequestMapping {}, error {}", name, e);
		}

	}
	@AfterReturning(
			pointcut = "within(@org.springframework.web.bind.annotation.RequestMapping *)",
			returning = "result")
	public void afterRequestMapping(JoinPoint jp, Object result) throws JsonProcessingException, OPException {
		String name = jp.getSignature().getName();
		log.info("afterRequestMapping name : {}", name);

		try{
			log.info("!StringUtils.isEmpty(name) : {}", !StringUtils.isEmpty(name));
			if(!StringUtils.isEmpty(name)) {

				Api_Log apiLog = LogHelper.getLogapivo();
				log.info("result : {}", result);
				SuperResponse res = (SuperResponse) result;
				if(StringUtils.isEmpty(res.getHeader().getSession_id())) {
					apiLog.setSession_id(" ");
				}else {
					apiLog.setSession_id(res.getHeader().getSession_id());
				}

				apiLog.setReturn_code("M000");
				apiLog.setReturn_msg("SUCCESSFUL");
				apiLog.setRes_time(DateUtil.qryNowTimeStamp());

				LogHelper.insertApiLog(apiLog, LogHelper.getReqJson(), JsonUtil.objectToJson(result),
						apiLogVo, apiDataLogVo);
			}
		} catch(Exception e){
			log.info("AfterRequestMapping {}, error {}", name, e);
		}
	}
}
