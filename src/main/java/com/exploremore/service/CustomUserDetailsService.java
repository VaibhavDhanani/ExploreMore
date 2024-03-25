package com.exploremore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import com.exploremore.dao.UserRepository;
import com.exploremore.entites.User;
import com.exploremore.exception.NoElementFoundException;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws NoElementFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new NoElementFoundException("User not found with username: " + username);
        }
        return new UserPrincipal(user);
    }
}
