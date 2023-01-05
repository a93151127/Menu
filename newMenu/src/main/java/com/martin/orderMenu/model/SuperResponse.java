package com.martin.orderMenu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.martin.orderMenu.model.SuperResponse.Header;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonRootName(value = "RESPONSE")
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

		@JsonProperty("RETURN_CODE")
		String return_code;
		
		@JsonProperty("RETURN_MSG")
		String return_msg;
	}
}
