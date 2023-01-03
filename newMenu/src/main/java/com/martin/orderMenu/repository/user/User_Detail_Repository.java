package com.martin.orderMenu.repository.user;

import com.martin.orderMenu.dao.user.User_Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface User_Detail_Repository extends JpaRepository<User_Detail, String> {
}
