package com.lx.dao;

import com.lx.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lx
 */
@Repository
public interface UserDao {
    /**
     * 查询所有用户
     *
     * @return 返回所有用户信息
     */
    List<User> findAll();

    /**
     * 添加用户
     *
     * @param user 用户信息
     * @return 返回int型操作记录
     */
    int addUser(User user);

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
    int updateUserMsg(User user);

    /**
     * 根据用户id进行删除
     *
     * @param id 用户id
     * @return 返回int型操作记录条数
     */
    int deleteUserMsg(Integer id);

    /**
     * 用户注册
     *
     * @param user 用户类型
     * @return 返回操作记录条数
     */
    int userRegister(User user);

    /**
     * 添加地址
     * @param id id
     * @param homeaddress 居住地址
     * @param workaddress 工作地址
     * @return 操作记录
     */
    int addAddress(@Param("id") Integer id,@Param("homeaddress") String homeaddress,@Param("workaddress") String workaddress,@Param("name")String name);

    /**
     * 更新地址
     * @param id id
     * @param homeaddress 居住地址
     * @param workaddress 工作地址
     * @return 操作记录
     */
    int updateAddress(@Param("id") Integer id,@Param("homeaddress") String homeaddress,@Param("workaddress") String workaddress);

    /**
     * 删除地址
     * @param id 用户id
     * @return 操作纪律
     */
    int deleteAddress(Integer id);
}
