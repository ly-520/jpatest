package com.example.jpatest.service;

import com.example.jpatest.entity.User;

public interface UserService {
    User saveUser(User user);
    void deleteUser(User user);
    void deleteUser(Long id);
    User updateUser(User user);
    User findUser(Long id);
}
