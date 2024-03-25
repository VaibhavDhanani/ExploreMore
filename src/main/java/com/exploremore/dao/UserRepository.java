package com.exploremore.dao;

import com.exploremore.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUserName(String username);
}
