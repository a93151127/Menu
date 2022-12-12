package com.martin.orderMenu.dao.log;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "api_data_log")
public class Api_Data_Log {
	
	//log id
	@Id
	private String log_seqno;
	
	//請求request
	private String req_json;
	
	//回復response
	private String res_json;
	
	//月份
	private String part_key;
}
