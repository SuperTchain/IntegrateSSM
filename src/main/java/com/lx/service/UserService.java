package com.lx.service;

import com.lx.model.User;

import java.util.List;

/**
 * @author lx
 */
public interface UserService {
    /**
     * 查询所有用户
     *
     * @return 返回所有用户信息
     */
    List<User> findAll();

    /**
     * 添加用户
     * @param user 用户信息
     * @return 返回int型操作记录
     */
    Boolean addUser(User user);

    /**
     * 根据用户名查询用户信息
     * @param username 用户名称
     * @return 用户信息
     */
    User findUserByName(String username);


    /**
     * 根据用户id查询
     * @param id 用户id
     * @return 返回一个用户信息
     */
    User findUserById(Integer id);

    /**
     * 更新用户信息
     * @param user 用户信息
     * @return 返回int型操作记录条数
     */
    Boolean updateUserMsg(User user);

    /**
     * 根据用户id进行删除
     * @param id 用户id
     * @return 返回int型操作记录条数
     */
    Boolean deleteUserMsg(Integer id);
}
