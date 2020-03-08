package com.lx.controller;

import com.lx.model.User;
import com.lx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/findAll")
    public  String findAll(){
        List<User> list=userService.findAll();
        for(User user:list)
        {
            System.out.println(user);
        }
        return "hello";
    }

}
