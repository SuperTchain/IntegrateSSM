package com.lx.dao;

import com.lx.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author lx
 */
@Repository
public interface LoginDao {
    /**
     * 根据用户名查询用户信息
     * @param username 用户名称
     * @return 用户信息
     */
    User findUserByName(String username);
}
