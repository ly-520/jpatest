package com.example.jpatest.querydsl.dao;

import com.example.jpatest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDao extends JpaRepository<User,Long>, JpaSpecificationExecutor<User>, PagingAndSortingRepository<User,Long> {
}
