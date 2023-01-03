package com.martin.orderMenu.model.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.martin.orderMenu.model.SuperBody;
import com.martin.orderMenu.model.SuperResponse;
import lombok.*;

public class LoginResponse extends SuperResponse {
    @JsonProperty("BODY")
    SuperBody body = null;

    public LoginResponse(Header header, SuperBody body) {
        super(header);
        this.body = body;
    }

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Body extends SuperBody{

        @JsonProperty("RESULT")
        private String result;

    }
}
