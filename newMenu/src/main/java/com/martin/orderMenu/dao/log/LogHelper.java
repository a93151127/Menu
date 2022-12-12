package com.martin.orderMenu.dao.log;

import java.util.Calendar;

import com.martin.orderMenu.service.Api_Data_Log_VO;
import com.martin.orderMenu.service.Api_Log_VO;
import com.martin.orderMenu.stringUtil.StringUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LogHelper {


	
	//上行
	public static final String TX_TYPE_UP = "1";
	//下行
	public static final String TX_TYPE_DOWN = "2";
	
	static final String DEFAULT_SEQ = "default123";
	//序號
	private static final ThreadLocal<String> LogSeqLocal = 
			new ThreadLocal<String>();
	//entry
	private static final ThreadLocal<String> ReqJson = 
			new ThreadLocal<String>();
	
	private static final ThreadLocal<Api_Log> LogApiVo =
			new ThreadLocal<Api_Log>();
			
	public static final String getLogSeq() {
		String logSeq = LogSeqLocal.get();
		if(logSeq == null) {
			logSeq = DEFAULT_SEQ;
		}
		return logSeq;
	}
	
	public static final void setLogSeq(String logSeq) {
		LogSeqLocal.set(logSeq);
	}
	
	public static final void setReqJson(String reqJson) {
		ReqJson.set(reqJson);
	}
	
	public static final String getReqJson() {
		return ReqJson.get();
	}
	
	public static Api_Log getLogapivo() {
		return LogApiVo.get();
	}
	
	public static final void setLogapivo(Api_Log apiLog) {
		LogApiVo.set(apiLog);
	}
	
	public static void insertApiLog(Api_Log apiLog, String req, String res,
									Api_Log_VO apiLogVo, Api_Data_Log_VO apiDataLogVo) {

		try {
			Api_Data_Log apiDataLog = new Api_Data_Log();
			
			Calendar cal = Calendar.getInstance();
			String partKey = StringUtils
					.leftPad(String.valueOf(cal.get(Calendar.MONTH)), 2, "0");
			apiDataLog.setLog_seqno(apiLog.getLog_seqno());
			apiDataLog.setPart_key(partKey);
			apiDataLog.setReq_json(req);
			apiDataLog.setRes_json(res);
			
			log.info(apiDataLog.toString());

			apiDataLogVo.save(apiDataLog);
			apiLogVo.save(apiLog);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
