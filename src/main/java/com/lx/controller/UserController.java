package com.lx.controller;

import com.lx.model.User;
import com.lx.service.UserService;
import com.mysql.cj.Session;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        return "user-list";
    }


    @RequestMapping("/addUser")
    public String addUser(User user) {
        System.out.println(user);
        userService.addUser(user);
        return "redirect:findAll";
    }

    @RequestMapping("/login")
    public String userLogin(@RequestParam(name = "username") String username,
                            @RequestParam(name = "password") String password,
                            HttpSession session) {
        System.out.println(username);
        System.out.println(password);
        //判断
        if (username == null || password == null) {
            return "redirect:/login.jsp";
        } else {
            //查询出用户信息
            User userByName = userService.findUserByName(username);
            if (userByName != null && userByName.getPassword().equals(password)) {
                //将用户名放入Model
                session.setAttribute("username", userByName.getName());
                return "main";
            }
            return "redirect:/login.jsp";
        }
    }

}
