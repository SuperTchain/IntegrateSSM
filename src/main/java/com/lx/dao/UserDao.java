package com.lx.dao;

import com.lx.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 声明dao
 */
@Repository
public interface UserDao {
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
