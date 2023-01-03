package com.martin.orderMenu.vo.user;

import com.martin.orderMenu.dao.user.User_Detail;
import com.martin.orderMenu.repository.user.User_Detail_Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
}
