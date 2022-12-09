package com.martin.orderMenu.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class SuperResponse {
	
	@JsonProperty("HEADER")
	Header header = null;
	
	@Getter
	@Setter
	@ToString
	public static class Header{
		@JsonProperty("SESSION_ID")
		String session_id;
		
		
		@JsonProperty("DEVICE_TYPE")
		String device_type;
		
		@JsonProperty("RETURN_MSG")
		String return_msg;
	}
}
