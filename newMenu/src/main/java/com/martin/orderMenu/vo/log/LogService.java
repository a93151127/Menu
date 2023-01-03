package com.martin.orderMenu.vo.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martin.orderMenu.dateUtil.DateUtil;
import com.martin.orderMenu.vo.Api_Log_VO;
import com.martin.orderMenu.stringUtil.StringUtils;

@Service
@Slf4j
public class LogService {
	
	@Autowired
	private Api_Log_VO apiLogVo;
	
	public String getSeqNo() {
		String seqNo = nextSeqNo();
		log.info("seqNo : {}", seqNo);
		return DateUtil.getFormatTime(DateUtil.LOG_FORMAT) + 
				StringUtils.leftPad(seqNo, 6, "0");
	}
	
	synchronized public String nextSeqNo() {
		return apiLogVo.getLogSeqNoSeq();
	}
}
