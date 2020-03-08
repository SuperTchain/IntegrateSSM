package com.lx.dao;

import com.lx.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

//声明Bean
@Repository
public interface UserDao {
//    查询所有用户信息
    List<User> findAll();
}
