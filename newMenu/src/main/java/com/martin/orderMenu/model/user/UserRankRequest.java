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
public class UserRankRequest extends SuperRequest {

    @JsonProperty("BODY")
    UserRankRequest.Body body = null;

    @Getter
    @Setter
    @ToString
    public static class Body{

        @JsonProperty("USER_RANK_ID")
        private String user_rank_id;

        @JsonProperty("USER_RANK_NAME")
        private String user_rank_name;
    }
}
