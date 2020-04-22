package com.lx.controller;

import com.lx.model.User;
import com.lx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<User> list = userService.findAll();
        model.addAttribute("user", list);
        for (User user : list) {
            System.out.println(user);
        }
        return "hello";
    }


    @RequestMapping("/addUser")
    public String addUser(User user) {
        userService.addUser(user);
        return "redirect:findAll";
    }

    @RequestMapping("/login")
    public String userLogin(@RequestParam(name = "username", required = true) String username,
                            @RequestParam(name = "password", required = true) String password) {
        //查询出用户信息
        User userByName = userService.findUserByName(username);
        //判断
        if (username.equals(userByName.getName()) && password.equals(userByName.getPassword())) {

            return "success";
        }
        return "login";
    }

}
