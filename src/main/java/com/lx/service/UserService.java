package com.lx.service;

import com.lx.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> findAll();

    /**
     * 添加用户
     *
     * @param user
     */
    void addUser(User user);

    /**
     * 根据username查询用户
     */
    User findUserByName(String username);
}
