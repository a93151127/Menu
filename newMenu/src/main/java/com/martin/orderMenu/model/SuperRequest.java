package com.martin.orderMenu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonRootName(value = "REQUEST")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SuperRequest{
	
	@JsonProperty("HEADER")
	Header header = null;
	
	@Getter
	@Setter
	@ToString
	public static class Header{
		
		@JsonProperty("API_ID")
		String api_id;
		
		@JsonProperty("SESSION_ID")
		String session_id;
	}

}
