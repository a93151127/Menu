package com.martin.orderMenu.service.userDetail;

import com.martin.orderMenu.dao.user.User_Detail;
import com.martin.orderMenu.dao.user.User_Rank;
import com.martin.orderMenu.model.SuperRequest;
import com.martin.orderMenu.model.user.UserDetailRequest;
import com.martin.orderMenu.model.user.UserRankRequest;
import com.martin.orderMenu.util.DateUtil;
import com.martin.orderMenu.vo.user.User_Rank_Vo;
import com.martin.orderMenu.vo.user.User_Detail_Vo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Slf4j
@Service
public class UserDetailService {

    @Autowired
    private User_Detail_Vo userDetailVo;
    @Autowired
    private User_Rank_Vo userRankVo;

    public void insertUserDetail(UserDetailRequest.Body mBody, SuperRequest.Header reqH){
        log.info("inside service");
        User_Detail userDetail = new User_Detail();
        userDetail.setUser_id(mBody.getUser_id());
        userDetail.setUser_gender(mBody.getUser_gender());
        userDetail.setUser_name(mBody.getUser_name());
        userDetail.setUser_phone(mBody.getUser_phone());
        userDetail.setUser_pd(mBody.getUser_pd());
        userDetail.setUserRank(userRankVo.findById(mBody.getUser_rank_id()));
        userDetail.setCreate_time(DateUtil.qryNowTimeStamp());
        userDetail.setUpdate_time(DateUtil.qryNowTimeStamp());

        userDetailVo.save(userDetail);
    }
}
