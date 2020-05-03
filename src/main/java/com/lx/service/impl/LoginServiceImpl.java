package com.lx.service.impl;

import com.lx.dao.LoginDao;
import com.lx.model.User;
import com.lx.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lx
 */
@Service
public class LoginServiceImpl implements LoginService {
    /**
     * 引入dao接口
     */
    @Resource
    LoginDao loginDao;

    /**
     * 根据username查询用户信息
     *
     * @param username 用户名称
     * @return 返回查询出的用户信息
     */
    @Override
    public User findUserByName(String username) {
        return loginDao.findUserByName(username);
    }
}
