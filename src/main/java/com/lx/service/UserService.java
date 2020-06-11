package com.lx.service;

import com.lx.model.User;
import com.sun.org.apache.xpath.internal.operations.Bool;

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
    List<User> findAll(int page, int size);

    /**
     * 添加用户
     *
     * @param user 用户信息
     * @return 返回int型操作记录
     */
    Boolean addUser(User user);

    /**
     * 根据用户id查询
     *
     * @param id 用户id
     * @return 返回一个用户信息
     */
    User findUserById(Integer id);

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     * @return 返回int型操作记录条数
     */
    Boolean updateUserMsg(User user);

    /**
     * 根据用户id进行删除
     *
     * @param id 用户id
     * @return 返回int型操作记录条数
     */
    Boolean deleteUserMsg(Integer id);


    /**
     * 用户注册
     *
     * @param user 用户类型
     * @return 操作记录数
     */
    Boolean userRegister(User user);

    /**
     * 添加地址
     * @param id id
     * @param homeaddress 居住地址
     * @param workaddress 工作地址
     * @return 操作记录
     */
    Boolean addAddress(Integer id,String homeaddress,String workaddress,String name);

    /**
     * 更新地址
     * @param id id
     * @param homeaddress 居住地址
     * @param workaddress 工作地址
     * @return 操作
     */
    Boolean updateAddress(Integer id,String homeaddress,String workaddress);

    /**
     * 删除地址
     * @param id 用户id
     * @return 操作记录
     */
    Boolean deleteAddress(Integer id);

    /**
     * 游客模糊查询博主
     * @param name 博主名
     * @param phonenumber 电话号码
     * @return 查询结果
     */
    List<User> tSearch(String name, String phonenumber);
}
