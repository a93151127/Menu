package com.martin.orderMenu.service.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martin.orderMenu.dateUtil.DateUtil;
import com.martin.orderMenu.service.Api_Log_VO;
import com.martin.orderMenu.stringUtil.StringUtils;

@Service
public class LogService {
	
	@Autowired
	private Api_Log_VO apiLogVo;
	
	public String getSeqNo() {
		String seqNo = nextSeqNo();
		return DateUtil.getFormatTime(DateUtil.LOG_FORMAT) + 
				StringUtils.leftPad(seqNo, 6, "0");
	}
	
	synchronized public String nextSeqNo() {
		return apiLogVo.getLogSeqNoSeq();
	}
}
