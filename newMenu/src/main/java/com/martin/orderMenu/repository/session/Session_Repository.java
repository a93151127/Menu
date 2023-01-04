package com.martin.orderMenu.repository.session;

import com.martin.orderMenu.dao.session.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface Session_Repository extends JpaRepository<Session, String> {

    @Query(value = "select * from session where user_id = ?1", nativeQuery = true)
    Session qrySessionByUserId(String user_id);

    @Modifying
    @Transactional
    @Query(value = "delete from session where user_id = ?1", nativeQuery = true)
    int deleteSessionByUserId(String user_id);
}
