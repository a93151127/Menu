package com.martin.orderMenu.vo.user;

import com.martin.orderMenu.codeNo.Const;
import com.martin.orderMenu.dao.user.User_Detail;
import com.martin.orderMenu.exception.OPException;
import com.martin.orderMenu.repository.user.User_Detail_Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@Component
public class User_Detail_Vo {

    @Autowired
    private User_Detail_Repository userDetailRepository;

    public void save(User_Detail userDetail){
        log.info("userDetail : {}", userDetail.toString());
        userDetailRepository.save(userDetail);
    }

    public User_Detail findByUser_idAndUser_pd(String user_id, String user_pd) throws OPException {
        log.info("user_id : {}", user_id);
        log.info("user_pd : {}", user_pd);

        User_Detail userDetail =userDetailRepository.findUserDetailByIdAndPd(user_id, user_pd);

        if(userDetail != null){
            return userDetail;
        }else {
            throw new OPException(Const.NO_ACCOUNT_WRONG_PD, "沒有該帳號或密碼錯誤");
        }
    }
}
