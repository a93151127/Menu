package com.martin.orderMenu.repository.user;

import com.martin.orderMenu.dao.user.User_Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public interface User_Detail_Repository extends JpaRepository<User_Detail, String> {
    @Query(value = "select * from user_detail where user_id = ?1 and user_pd = ?2", nativeQuery = true)
    User_Detail findUserDetailByIdAndPd(String user_id, String user_pd);
}
