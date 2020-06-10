package com.lx.dao;

import com.lx.model.UserAddress;
import org.springframework.stereotype.Repository;

/**
 * @author lx
 */
@Repository
public interface UserAddressDao {
    /**
     * 查询所有用户地址
     *
     * @param id 用户id
     * @return 用户地址信息
     */
    UserAddress findAllAddress(Integer id);
}
