package com.example.jpatest.controller;


import com.example.jpatest.entity.User;
import com.example.jpatest.querydsl.service.UserService;
import com.example.jpatest.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuerydslApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    public void contextLoads() {
    }

    /**
     * @Description 测试查询全部方法
     * @Author LinLuoChen
     * @Date  11:22
     **/
    @Test
    public void  QueryDSLTest(){
        User user = new User();
        List<User> list = userService.findAll(user);
        System.out.println(list);
    }

    @Test
    private void findUser(Long id){
        User user =  userServiceImpl.findUser(id);
        System.out.println(user.toString());
    }

}