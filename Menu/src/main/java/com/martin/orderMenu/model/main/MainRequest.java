package com.martin.orderMenu.model.main;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.martin.orderMenu.model.SuperRequest;

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
public class MainRequest extends SuperRequest{
	
	@JsonProperty("BODY")
	Body body = null;
	
	@Getter
	@Setter
	@ToString
	public static class Body{
		
		@JsonProperty("PRODUCT_NAME")
		private String product_name;

	}
}
