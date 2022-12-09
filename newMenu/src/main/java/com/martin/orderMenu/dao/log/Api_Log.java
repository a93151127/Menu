package com.martin.orderMenu.dao.log;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "api_log")
public class Api_Log {
	
	//log id
	@Id
	private String log_seqno;
	
	//api編號
	private String api_id;
	
	//請求時間
	private String req_time;
	
	//回復時間
	private String res_time;
	
	//回覆編碼
	private String return_code;
	
	//回覆訊息
	private String return_msg;
	
	//session
	private String session_id;
	
	//月份
	private String part_key;
}
