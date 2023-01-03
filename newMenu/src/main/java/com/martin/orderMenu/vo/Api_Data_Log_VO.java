package com.martin.orderMenu.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.martin.orderMenu.dao.log.Api_Data_Log;
import com.martin.orderMenu.repository.log.Api_Data_Log_Repository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Component
public class Api_Data_Log_VO {
	@Autowired
	private Api_Data_Log_Repository apiDataLogRepository;
	
	public void save(Api_Data_Log apiDataLog) {
		log.info("apiDataLogRepository===" + apiDataLogRepository);
		apiDataLogRepository.save(apiDataLog);
	}
}
