package com.martin.orderMenu.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martin.orderMenu.repository.Api_Log_Repository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Api_Log_VO {
	
	@Autowired
	private Api_Log_Repository apiLogRepository;
	
	public String getLogSeqNoSeq() {
		return apiLogRepository.getLogSeqNoSeq()[0];
	}
}
