package com.example.spring_caching_transactions.Services;

import com.example.spring_caching_transactions.Entities.User;
import com.example.spring_caching_transactions.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

@Service
public class UserService {

    @Autowired
    UserRepo userrepo;

    @Cacheable(cacheNames = "User" ,key = "#Id")
    public User getUser(Long Id){
        return userrepo.findById(Id).orElse(null);
    }

    @CachePut(cacheNames = "User" ,key = "#user.id")
    public User createUser(User user) {
        return userrepo.save(user);
    }

    @CachePut(cacheNames = "User" ,key = "#id")
    public User updateUser(Long id, User user) {
        User Getuser=userrepo.findById(id).orElseThrow(()->new ResourceAccessException("No User Found"));

        if(Getuser==null || id!=Getuser.getId()){
            throw new ResourceAccessException("Invalid User Id");
        }
        Getuser.setName(user.getName());
        Getuser.setEmail(user.getEmail());

        return userrepo.save(Getuser);

    }
}
