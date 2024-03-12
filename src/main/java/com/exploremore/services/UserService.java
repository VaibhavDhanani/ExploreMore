package com.exploremore.services;

import com.exploremore.dao.UserRepository;
import com.exploremore.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserService {

    @Autowired
    private UserRepository userRepo ;

    @GetMapping("/all")
    @ResponseBody
    public List<User> all()
    {
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public User user_by_id(@PathVariable int id)
    {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }

    }

}
