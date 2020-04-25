package com.lx.controller;

import com.lx.model.User;
import com.lx.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lx
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    /**
     * 引入service接口
     */
    @Autowired
    private UserService userService;

    /**
     * 日志监控
     */
    private static Logger logger=Logger.getLogger(UserController.class);

    /**
     * 查询所有用户信息
     *
     * @param model 封装的数据
     * @return 返回到用户列表页面
     */
    @GetMapping(value = "/findAll")
    public String findAll(Model model) {
        List<User> list = userService.findAll();
        model.addAttribute("user", list);
        logger.info("查询成功");
        return "user-list";
    }


    /**
     * 添加用户
     *
     * @param user 用户信息
     * @return 返回用户列表页面
     */
    @PostMapping("/addUser")
    public String addUser(User user) {
        //判断是否添加成功
        if(Boolean.TRUE.equals(userService.addUser(user))){
            logger.info("添加成功");
            return "redirect:findAll";
        }
        return "addUser";
    }

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @param session session
     * @return 成功返回到主界面 失败返回登录界面
     */
    @PostMapping("/login")
    public String userLogin(@RequestParam(name = "username") String username,
                            @RequestParam(name = "password") String password,
                            HttpSession session) {
        //后端校验是否为空
        if (username == null || password == null) {
            return "redirect:/login.jsp";
        } else {
            //查询出用户信息
            User userByName = userService.findUserByName(username);
            if (userByName != null && userByName.getPassword().equals(password)) {
                //将用户名放入Model
                session.setAttribute("username", userByName.getName());
                logger.info("登录成功");
                return "main";
            }
            return "redirect:/login.jsp";
        }
    }


    /**
     * 根据Id修改用户信息
     *
     * @param id 用户id
     * @return 返回到修改界面
     */
    @GetMapping("/edit")
    public String editUserMsg(@RequestParam(name = "id") Integer id,Model model) {
        //查询用户信息
        User userById = userService.findUserById(id);
        model.addAttribute("user",userById);
        logger.info("查询成功");
        return "edit";
    }

    /**
     * 更新修改的用户信息
     * @param user 用户信息
     * @return 成功返回到用户列表信息，失败返回到修改界面
     */
    @PostMapping("/update")
    public  String updateEditMsg(User user){
        if (Boolean.TRUE.equals(userService.updateUserMsg(user))){
            logger.info("更新成功");
            return "redirect:findAll";
        }
        return "edit";
    }

    /**
     * 根据id删除用户
     * @param id 用户id
     * @return 成功返回更新用户列表，失败返回用户列表
     */
    @GetMapping("/delete")
    public String deleteUser(@RequestParam(name = "id") Integer id){
        if (Boolean.TRUE.equals(userService.deleteUserMsg(id))){
            logger.info("删除成功");
            return "redirect:findAll";
        }
        return  "user-list";
    }

}
