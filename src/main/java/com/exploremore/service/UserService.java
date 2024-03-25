package com.exploremore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.exploremore.dao.UserRepository;
import com.exploremore.entites.User;


@Service
public class UserService {

    @Autowired
    private UserRepository repo;

private final BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder(10);
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println("+\n\n\n\n\n+"+user.getPassword()+"+\n\n\n\n\n+");
        return repo.save(user);
    }
}
