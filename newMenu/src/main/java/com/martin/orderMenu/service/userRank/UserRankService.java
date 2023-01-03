package com.martin.orderMenu.service.userRank;

import com.martin.orderMenu.dao.user.User_Rank;
import com.martin.orderMenu.model.SuperRequest;
import com.martin.orderMenu.model.main.MainRequest;
import com.martin.orderMenu.model.user.UserRankRequest;
import com.martin.orderMenu.vo.user.User_Rank_Vo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
@Slf4j
@Service
public class UserRankService {

    @Autowired
    private User_Rank_Vo userRankVo;

    public void insertUserRank(UserRankRequest.Body mBody, SuperRequest.Header reqH){
        log.info("inside service");
        User_Rank userRank = new User_Rank();
        userRank.setUser_rank_id(mBody.getUser_rank_id());
        userRank.setUser_rank_name(mBody.getUser_rank_name());
        Long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        userRank.setCreate_time(timestamp);
        userRank.setUpdate_time(timestamp);

        userRankVo.save(userRank);
    }
}
