package com.martin.orderMenu.dao.user;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user_detail")
public class User_Detail {
    //log id
    @Id
    private String user_id;

    //請求request
    private String user_pd;

    //請求request
    private String user_name;

    //回復response
    private String user_gender;

    //月份
    private String user_phone;

    //申請會員時間
    private Timestamp create_time;

    //更改會員時間
    private Timestamp update_time;

    @ManyToOne(fetch=FetchType.LAZY) // @ManyToOne JPA預設的fetch=FetchType.EAGER，改為FetchType.LAZY
    @JoinColumn(name="user_rank_id")
        private User_Rank userRank;
}
