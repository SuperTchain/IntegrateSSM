package com.lx.service;

import com.lx.model.User;

public interface LoginService {
    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名称
     * @return 用户信息
     */
    User findUserByName(String username);

//    String findUserRoleByName(String role);
}
