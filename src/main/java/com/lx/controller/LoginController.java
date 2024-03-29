package com.lx.controller;

import com.lx.annotation.LogAnnotation;
import com.lx.model.User;
import com.lx.service.LoginService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author lx
 */
@Controller
public class LoginController {
    /**
     * 引入service接口
     */
    @Autowired
    private LoginService loginService;

    /**
     * 日志监控
     */
    private static Logger logger = Logger.getLogger(LoginController.class);

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @param session  session
     * @return 成功返回到主界面 失败返回登录界面
     */
    @PostMapping("/login")
    @LogAnnotation(name = "登录", url = "/login")
    public String userLogin(@RequestParam(name = "username") String username,
                            @RequestParam(name = "password") String password,
                            String role,
                            HttpSession session) {
        //后端校验是否为空
        if (username == null || password == null||role==null) {
            return "redirect:/login.jsp";
        } else {
            //查询出用户信息
            User userByName = loginService.findUserByName(username);
            if (userByName != null && userByName.getPassword().equals(password)) {
                if (userByName.getRole().equals(role)) {

                    //将用户名放入session
                    session.setAttribute("username", userByName.getName());
                    session.setAttribute("userHead", userByName.getImg());
                    logger.info("登录成功");
                    if (role.equals("1")) {
                        return "admin/main";
                    } else {
                        return "blogAuthor/main";
                    }
                } else {
                    session.setAttribute("errmsg", "身份错误");
                    return "redirect:/login.jsp";
                }
            }
            //查询用户不存在或者密码错误
            session.setAttribute("errmsg", "用户名或者密码错误");
            return "redirect:/login.jsp";
        }
    }

    /**
     * 退出
     *
     * @param session 会话
     * @return 登录界面
     */
    @GetMapping("/logout")
    @LogAnnotation(name = "退出", url = "/logout")
    public String logout(HttpSession session) {
        return "redirect:/login.jsp";
    }

    /**
     * 用户注册
     *
     * @return 注册界面
     */
    @GetMapping("/register")
    public String register() {
        return "/userRegister.jsp";
    }
}
