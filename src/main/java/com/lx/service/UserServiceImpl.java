package com.lx.service;

import com.lx.dao.UserDao;
import com.lx.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//声明业务
@Service
public class UserServiceImpl implements UserService{
//    自动注入
    @Resource
    UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
