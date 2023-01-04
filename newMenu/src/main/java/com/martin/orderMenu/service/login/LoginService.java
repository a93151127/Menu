package com.martin.orderMenu.service.login;

import com.martin.orderMenu.dao.session.Session;
import com.martin.orderMenu.dao.user.User_Detail;
import com.martin.orderMenu.dao.user.User_Rank;
import com.martin.orderMenu.exception.OPException;
import com.martin.orderMenu.model.SuperRequest;
import com.martin.orderMenu.model.login.LogOutRequest;
import com.martin.orderMenu.model.login.LoginRequest;
import com.martin.orderMenu.model.user.UserRankRequest;
import com.martin.orderMenu.util.DateUtil;
import com.martin.orderMenu.vo.session.Session_VO;
import com.martin.orderMenu.vo.user.User_Detail_Vo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
@Slf4j
@Service
public class LoginService {

    @Autowired
    private User_Detail_Vo userDetailVo;

    @Autowired
    private Session_VO sessionVo;

    public void login(LoginRequest.Body mBody, SuperRequest.Header reqH,
                               HttpServletRequest req) throws OPException {
        log.info("inside LoginService");

        try{
            User_Detail userDetail = userDetailVo.findByUser_idAndUser_pd(mBody.getUser_id(),
                    mBody.getUser_pd());
            sessionVo.deleteSessionByUserId(mBody.getUser_id());
            insertSession(mBody, userDetail, req);
        }catch(OPException op){
            throw op;
        }
    }
    public void logout(LogOutRequest.Body mBody, SuperRequest.Header reqH,
                       HttpServletRequest req) throws OPException {
        log.info("inside LogoutService");
        sessionVo.deleteById(reqH.getSession_id());
    }
    public void insertSession(LoginRequest.Body mBody, User_Detail userDetail, HttpServletRequest req){
        Session session = new Session();

        session.setSession_id(req.getSession().getId());
        session.setUser_id(mBody.getUser_id());
        session.setUser_pd(mBody.getUser_pd());
        session.setUser_rank_id(userDetail.getUserRank().getUser_rank_id());
        session.setCreate_time(DateUtil.qryNowTimeStamp());
        session.setUser_ip(req.getRemoteAddr());

        sessionVo.save(session);
    }
}
