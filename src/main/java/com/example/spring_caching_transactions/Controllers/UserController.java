package com.example.spring_caching_transactions.Controllers;

import com.example.spring_caching_transactions.Entities.User;
import com.example.spring_caching_transactions.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userServ;


    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){
        return userServ.getUser(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userServ.createUser(user);
    }

    @PostMapping("/user/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User user){
        return userServ.updateUser(id,user);
    }
}
