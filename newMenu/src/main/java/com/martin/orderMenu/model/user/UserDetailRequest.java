package com.martin.orderMenu.model.user;

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
public class UserDetailRequest  extends SuperRequest {

    @JsonProperty("BODY")
    UserDetailRequest.Body body = null;

    @Getter
    @Setter
    @ToString
    public static class Body{

        @JsonProperty("USER_ID")
        private String user_id;

        @JsonProperty("USER_GENDER")
        private String user_gender;

        @JsonProperty("USER_NAME")
        private String user_name;

        @JsonProperty("USER_PHONE")
        private String user_phone;

        @JsonProperty("USER_RANK_ID")
        private String user_rank_id;
    }
}
