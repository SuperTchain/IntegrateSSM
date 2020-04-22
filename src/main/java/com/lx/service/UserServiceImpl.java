package com.lx.service;

import com.lx.dao.UserDao;
import com.lx.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 声明业务
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * 引入dao
     */
    @Resource
    UserDao userDao;

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    /**
     * 添加用户
     *
     * @param user
     */
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    /**
     * 根据username查询用户信息
     *
     * @param username
     * @return
     */
    @Override
    public User findUserByName(String username) {
        return userDao.findUserByName(username);
    }
}
