package com.lx.service;

import com.lx.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    //    查询所有用户信息
    List<User> findAll();
}
