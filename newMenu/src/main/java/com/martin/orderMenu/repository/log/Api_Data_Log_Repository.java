package com.martin.orderMenu.repository.log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.martin.orderMenu.dao.log.Api_Data_Log;
import com.martin.orderMenu.dao.log.Api_Log;

@Service
public interface Api_Data_Log_Repository extends JpaRepository<Api_Data_Log, String>{

}
