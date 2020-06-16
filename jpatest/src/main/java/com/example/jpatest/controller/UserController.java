package com.example.jpatest.controller;

import com.example.jpatest.entity.User;
import com.example.jpatest.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("add")
    private User addUser(String nickName,String telNum){
        User user = new User();
        user.setNickname(nickName);
        user.setTelnum(telNum);
        userServiceImpl.saveUser(user);
        return user;
    }


    @GetMapping("del")
    private String delUser(Long id){
        userServiceImpl.deleteUser(id);
        return "SUCCESS";
    }


    @GetMapping("update")
    private User updateUser(Long id,String nickName){
        User user = userServiceImpl.findUser(id);
        user.setNickname(nickName);
        userServiceImpl.updateUser(user);
        return user;
    }


    @GetMapping("find")
    private User findUser(Long id){
        return userServiceImpl.findUser(id);
    }
}