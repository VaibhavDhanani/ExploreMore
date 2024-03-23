package com.exploremore.controller;

import com.exploremore.dao.UserRepository;
import com.exploremore.entites.User;
import com.exploremore.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

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
        if(userRepo.findById(id).isEmpty())
        {
            throw new BadRequestException("No Such User Found");
        }
        Optional<User> optionalUser = userRepo.findById(id);
        return optionalUser.orElse(null);
    }
    @PostMapping("/add")
    public User addUser(@RequestBody User user)
    {
        userRepo.save(user);
        return user;
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user)
    {
        if(userRepo.findById(id).isEmpty())
        {
            throw new BadRequestException("No Such User Found");
        }
        return userRepo.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id)
    {
        if(userRepo.findById(id).isEmpty())
        {
            throw new BadRequestException("No Such User Found");
        }
        userRepo.deleteById(id);
    }
}
