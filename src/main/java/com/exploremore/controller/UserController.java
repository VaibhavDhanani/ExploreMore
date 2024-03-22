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
        if(id <= 0 || id >= userRepo.findAll().size())
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
        if(id <= 0 || id >= userRepo.findAll().size())
        {
            throw new BadRequestException("No Such User Found");
        }
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            User user1 = optionalUser.get();
            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            user1.setUserName(user.getUserName());
            user1.setEmail(user.getEmail());
            user1.setPassword(user.getPassword());
            user1.setPhoneNo(user.getPhoneNo());
            userRepo.save(user1);
            return user1;
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id)
    {
        if(id <= 0 || id >= userRepo.findAll().size())
        {
            throw new BadRequestException("No Such User Found");
        }
        userRepo.deleteById(id);
    }
}
