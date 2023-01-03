package com.martin.orderMenu.vo.user;

import com.martin.orderMenu.dao.user.User_Rank;
import com.martin.orderMenu.repository.user.User_Rank_Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Component
public class User_Rank_Vo {
    @Autowired
    private User_Rank_Repository userRankRepository;

    public void save(User_Rank userRank){
        log.info("userRank : {}", userRank.toString());
        userRankRepository.save(userRank);
    }

    public User_Rank findById(String userRankId){
        log.info("userRankId : {}", userRankId);
        return userRankRepository.findById(userRankId).get();
    }
}
