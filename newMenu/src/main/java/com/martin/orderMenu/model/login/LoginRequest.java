package com.martin.orderMenu.model.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.martin.orderMenu.model.SuperRequest;
import com.martin.orderMenu.model.user.UserDetailRequest;
import lombok.*;

@JsonRootName(value = "REQUEST")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginRequest extends SuperRequest {

    @JsonProperty("BODY")
    LoginRequest.Body body = null;

    @Getter
    @Setter
    @ToString
    public static class Body{

        @JsonProperty("USER_ID")
        private String user_id;

        @JsonProperty("USER_PD")
        private String user_pd;

    }
}
