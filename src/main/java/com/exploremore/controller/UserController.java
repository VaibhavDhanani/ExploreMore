package com.exploremore.controller;

import com.exploremore.dao.UserRepository;
import com.exploremore.entites.User;
import com.exploremore.exception.NoElementFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepo ;

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @ResponseBody
    public List<User> all()
    {
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('MANAGER','USER','ADMIN')")
    public User userById(@PathVariable Long id)
    {
        if(userRepo.findById(id).isEmpty())
        {
            throw new NoElementFoundException("No Such User Found");
        }
        Optional<User> optionalUser = userRepo.findById(id);
        return optionalUser.orElse(null);
    }
    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('MANAGER','USER','ADMIN')")
    public User addUser(@RequestBody User user)
    {
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return user;
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public User updateUser(@PathVariable Long id, @RequestBody User user)
    {
        if(userRepo.findById(id).isEmpty())
        {
            throw new NoElementFoundException("No Such User Found");
        }
        return userRepo.save(user);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public void deleteUser(@PathVariable Long id)
    {
        if(userRepo.findById(id).isEmpty())
        {
            throw new NoElementFoundException("No Such User Found");
        }
        userRepo.deleteById(id);
    }
}
