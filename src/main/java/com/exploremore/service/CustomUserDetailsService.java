package com.exploremore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import com.exploremore.dao.UserRepository;
import com.exploremore.entites.User;
import com.exploremore.entites.UserPrincipal;
import com.exploremore.exception.BadRequestException;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws BadRequestException {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new BadRequestException("User not found with username: " + username);
        }
        return new UserPrincipal(user);
    }
}
