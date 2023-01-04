package com.martin.orderMenu.model.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.martin.orderMenu.model.SuperRequest;
import lombok.*;

@JsonRootName(value = "REQUEST")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LogOutRequest extends SuperRequest {

    @JsonProperty("BODY")
    LogOutRequest.Body body = null;

    @Getter
    @Setter
    @ToString
    public static class Body{

    }
}
