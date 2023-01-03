package com.martin.orderMenu.dao.session;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "session")
public class Session {
    //log id
    @Id
    private String session_id;

    //請求request
    private String user_id;

    //請求request
    private String user_pd;

    //回復response
    private String user_rank_id;

    //月份
    private String user_ip;

    //申請會員時間
    private Timestamp create_time;

}
