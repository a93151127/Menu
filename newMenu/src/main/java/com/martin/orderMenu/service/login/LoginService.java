package com.martin.orderMenu.service.login;

import com.martin.orderMenu.dao.user.User_Rank;
import com.martin.orderMenu.exception.OPException;
import com.martin.orderMenu.model.SuperRequest;
import com.martin.orderMenu.model.login.LoginRequest;
import com.martin.orderMenu.model.user.UserRankRequest;
import com.martin.orderMenu.vo.user.User_Detail_Vo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
@Slf4j
@Service
public class LoginService {

    @Autowired
    private User_Detail_Vo userDetailVo;

    public void insertUserRank(LoginRequest.Body mBody, SuperRequest.Header reqH) throws OPException {
        log.info("inside LoginService");

        try{
            userDetailVo.findByUser_idAndUser_pd(mBody.getUser_id(),
                    mBody.getUser_pd());
        }catch(OPException op){
            throw op;
        }
    }
}
