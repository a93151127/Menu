package com.martin.orderMenu.model.main;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.martin.orderMenu.model.SuperBody;
import com.martin.orderMenu.model.SuperResponse;

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
public class MainResponse extends SuperResponse{
	
	@JsonProperty("BODY")
	SuperBody body = null;
	
	public final SuperBody getBody() {
		return body;
	}
	
	public final void setBody(SuperBody body) {
		this.body = body;
	}
	
	public MainResponse(Header header, SuperBody body) {
		super(header);
		this.body = body;
	}
	
	@Getter
	@Setter
	@ToString
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Body extends SuperBody{
		
		@JsonProperty("PRODUCT_NAME")
		private String product_name;

	}
}
