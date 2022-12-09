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
@Table(name = "api_data_log")
public class Api__Data_Log {
	
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
