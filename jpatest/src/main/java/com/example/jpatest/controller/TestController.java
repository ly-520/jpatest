package com.example.jpatest.controller;

import com.example.jpatest.entity.User;
import com.example.jpatest.querydsl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> test(){
        User user = new User();
        user.setNickname("wanger");
        List<User> userlist = userService.findAll(user);
        for (User user1 : userlist){
            System.out.println(user1.toString());
        }
        return userlist;
    }

}
