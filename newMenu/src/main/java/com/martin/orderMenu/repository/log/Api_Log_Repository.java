package com.martin.orderMenu.repository.log;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.martin.orderMenu.dao.log.Api_Log;
@Service
public interface Api_Log_Repository extends JpaRepository<Api_Log, String>{
	
	@Query(value = "select next_val as NEXTVAL from hibernate_sequence", nativeQuery = true)
	public String[] getLogSeqNoSeq();
}
