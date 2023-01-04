package com.martin.orderMenu.vo.session;

import com.martin.orderMenu.repository.log.Api_Data_Log_Repository;
import com.martin.orderMenu.repository.session.Session_Repository;
import com.martin.orderMenu.dao.session.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@Component
public class Session_VO {

    @Autowired
    private Session_Repository sessionRepository;

    public Session qrySessionByUserId(String userId){
        return sessionRepository.qrySessionByUserId(userId);
    }

    public void save(Session session){
        sessionRepository.save(session);
    }

    public void deleteById(String sessionId){
        sessionRepository.deleteById(sessionId);
    }

    public int deleteSessionByUserId(String userId){
        return sessionRepository.deleteSessionByUserId(userId);
    }

    public Session findById(String sessionId){
        Session session = null;

        if(sessionRepository.findById(sessionId).isPresent()){
            session = sessionRepository.findById(sessionId).get();
        }
        log.info("session object : {}", session);
        return session;
    }
}
