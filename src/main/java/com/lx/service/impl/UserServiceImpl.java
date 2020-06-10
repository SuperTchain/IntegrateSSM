package com.lx.service.impl;

import com.github.pagehelper.PageHelper;
import com.lx.dao.UserDao;
import com.lx.model.User;
import com.lx.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lx
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    /**
     * 引入dao接口
     */
    @Resource
    UserDao userDao;

    /**
     * 查询所有用户
     *
     * @return 返回一个list集合
     */
    @Override
    public List<User> findAll(int page, int size) {
        PageHelper.startPage(page, size);
        return userDao.findAll();
    }

    /**
     * 添加用户
     *
     * @param user 添加的用户信息
     * @return 返回true or false
     */
    @Override
    public Boolean addUser(User user) {
        return userDao.addUser(user) == 1 ? true : false;
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
     *
     * @param user 用户信息
     * @return 返回true or false
     */
    @Override
    public Boolean updateUserMsg(User user) {
        return userDao.updateUserMsg(user) == 1 ? true : false;
    }

    /**
     * 根据用户id进行删除
     *
     * @param id 用户id
     * @return 返回true or false
     */
    @Override
    public Boolean deleteUserMsg(Integer id) {
        return userDao.deleteUserMsg(id) == 1 ? true : false;
    }

    /**
     * 用户注册
     *
     * @param user 用户类型
     * @return 返回true or false
     */
    @Override
    public Boolean userRegister(User user) {
        return userDao.userRegister(user) == 1 ? true : false;
    }

    /**
     * 添加地址
     * @param id id
     * @param homeaddress 居住地址
     * @param workaddress 工作地址
     * @return 操作
     */
    @Override
    public Boolean addAddress(Integer id,String homeaddress,String workaddress,String name) {
        return userDao.addAddress(id,homeaddress,workaddress,name)==1?true:false;
    }

    /**
     * 更新地址
     * @param id id
     * @param homeaddress 居住地址
     * @param workaddress 工作地址
     * @return 操作
     */
    @Override
    public Boolean updateAddress(Integer id,String homeaddress,String workaddress) {
        return userDao.updateAddress(id,homeaddress,workaddress)==1?true:false;
    }

    /**
     * 删除地址
     * @param id 用户id
     * @return 操作
     */
    @Override
    public Boolean deleteAddress(Integer id) {
        return userDao.deleteAddress(id)==1?true:false;
    }
}
