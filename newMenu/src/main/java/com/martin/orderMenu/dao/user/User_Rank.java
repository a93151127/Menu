package com.martin.orderMenu.dao.user;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user_rank")
public class User_Rank {

    @Id
    private String user_rank_id;

    //請求request
    private String user_rank_name;

    //申請會員時間
    private Timestamp create_time;

    //更改會員時間
    private Timestamp update_time;



    @OneToMany(mappedBy="user_id", cascade={CascadeType.PERSIST, CascadeType.MERGE}) // 串聯新增和更新
    private List<User_Detail> userDetailList;
}
