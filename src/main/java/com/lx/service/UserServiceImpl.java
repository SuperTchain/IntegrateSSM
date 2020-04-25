package com.lx.service;

import com.lx.dao.UserDao;
import com.lx.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lx
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * 引入dao接口
     */
    @Resource
    UserDao userDao;

    /**
     * 查询所有用户
     * @return 返回一个list集合
     */
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    /**
     * 添加用户
     * @param user 添加的用户信息
     * @return 返回true or false
     */
    @Override
    public Boolean addUser(User user) {
        return userDao.addUser(user)==1?true:false;
    }

    /**
     * 根据username查询用户信息
     * @param username 用户名称
     * @return 返回查询出的用户信息
     */
    @Override
    public User findUserByName(String username) {
        return userDao.findUserByName(username);
    }

    /**
     * 根据id查询用户信息
     *
     * @param id 用户id
     * @return 返回查询出的用户信息
     */
    @Override
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    /**
     * 更新用户信息
     * @param user 用户信息
     * @return 返回true or false
     */
    @Override
    public Boolean updateUserMsg(User user) {
        return userDao.updateUserMsg(user)==1?true:false;
    }

    /**
     * 根据用户id进行删除
     * @param id 用户id
     * @return 返回true or false
     */
    @Override
    public Boolean deleteUserMsg(Integer id) {
        return userDao.deleteUserMsg(id)==1?true:false;
    }
}
