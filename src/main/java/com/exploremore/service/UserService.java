package com.exploremore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.exploremore.dao.UserRepository;
import com.exploremore.entites.User;


@Service
public class UserService {


    @Autowired
    UserRepository repo;

private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder(12);
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println("+\n\n\n\n\n+"+user.getPassword()+"+\n\n\n\n\n+");
        return repo.save(user);
    }
}
