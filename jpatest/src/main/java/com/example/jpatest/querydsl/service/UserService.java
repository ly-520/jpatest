package com.example.jpatest.querydsl.service;

import com.example.jpatest.entity.QUser;
import com.example.jpatest.entity.User;
import com.example.jpatest.querydsl.dao.UserDao;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    private EntityManager entityManager;

    //查询工厂实体
    private JPAQueryFactory queryFactory;

    //实例化控制器完成后执行该方法实例化JPAQueryFactory
    @PostConstruct
    public void initFactory()
    {
        queryFactory = new JPAQueryFactory(entityManager);
    }

    /**
     * @Description 查询全部
     * @Author LinLuoChen
     * @Date  10:53
     * @return java.util.List<com.cs.querydsl.model.User>
     **/
    public List<User> findAll(User user) {
        // 使用 QueryDSL 进行查询
        QUser qUser = QUser.user;
        // 定于获取条件
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        // 要查询的条件
        if(!StringUtils.isEmpty(user.getNickname())){
            // 放入要查询的条件信息
            //booleanBuilder.and(qUser.name.contains(user.getName()));
            booleanBuilder.and(qUser.nickname.eq(user.getNickname()));
        }
        // queryFactory 是上方定义的工厂实体
        // select（生成的实体类的字段）.from（生成实体类的名称）.where（上方要查询的条件）.orderBy（排序）.fetch（）进行查询
        return queryFactory.select(qUser)
                .from(qUser)
                .where(booleanBuilder)
                .orderBy(qUser.nickname.desc())
                .fetch();
    }
}
