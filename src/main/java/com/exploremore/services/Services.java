package com.exploremore.services;

import com.exploremore.dao.UserRepository;
import com.exploremore.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Services {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    @ResponseBody
    public List<User> users()
    {
        return userRepository.findAll();
    }

}
