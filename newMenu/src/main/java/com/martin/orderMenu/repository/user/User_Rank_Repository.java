package com.martin.orderMenu.repository.user;


import com.martin.orderMenu.dao.user.User_Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface User_Rank_Repository extends JpaRepository<User_Rank, String> {
}
