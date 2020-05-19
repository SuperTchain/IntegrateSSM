package com.lx.controller;

import com.github.pagehelper.PageInfo;
import com.lx.annotation.LogAnnotation;
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
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
    private static Logger logger = Logger.getLogger(UserController.class);

    /**
     * 查询所有用户信息
     *
     * @param model 封装的数据
     * @return 返回到用户列表页面
     */
    @LogAnnotation(name = "查询所有用户操作")
    @GetMapping(value = "/findAll")
    public String findAll(@RequestParam(name = "page",  defaultValue = "1") int page,
                          @RequestParam(name = "size",  defaultValue = "5") int size, Model model) {
        List<User> list = userService.findAll(page, size);
        //将查询结果放进pageinfo
        PageInfo pageInfo = new PageInfo(list);
        model.addAttribute("pageInfo", pageInfo);
        logger.info("查询成功");
        logger.info(list);
        return "user-list";
    }

    /**
     * 来到添加用户界面
     *
     * @return 添加界面
     */
    @GetMapping("/addUser")
    public String toAddUser() {
        return "addUser";
    }

    /**
     * 返回到主界面
     *
     * @return 用户列表界面
     */
    @GetMapping("/returnMain")
    public String toMain() {
        return "main";
    }

    /**
     * 添加用户
     *
     * @param user 用户信息
     * @return 返回用户列表页面
     */
    @LogAnnotation(name = "添加用户操作")
    @PostMapping("/addUser")
    public String addUser(User user) {
        //判断是否添加成功
        if (Boolean.TRUE.equals(userService.addUser(user))) {
            logger.info("添加成功");
            return "redirect:findAll";
        }
        return "addUser";
    }

    /**
     * 根据Id修改用户信息
     *
     * @param id 用户id
     * @return 返回到修改界面
     */
    @LogAnnotation(name = "编辑用户信息操作")
    @GetMapping("/edit")
    public String editUserMsg(@RequestParam(name = "id") Integer id, Model model) {
        //查询用户信息
        User userById = userService.findUserById(id);
        model.addAttribute("user", userById);
        logger.info("查询成功");
        return "edit";
    }

    /**
     * 更新修改的用户信息
     *
     * @param user 用户信息
     * @return 成功返回到用户列表信息，失败返回到修改界面
     */
    @LogAnnotation(name = "更新用户信息操作")
    @PostMapping("/update")
    public String updateEditMsg(User user) {
        if (Boolean.TRUE.equals(userService.updateUserMsg(user))) {
            logger.info("更新成功");
            return "redirect:findAll";
        }
        return "edit";
    }

    /**
     * 根据id删除用户
     *
     * @param id 用户id
     * @return 成功返回更新用户列表，失败返回用户列表
     */
    @LogAnnotation(name = "删除用户操作")
    @GetMapping("/delete")
    public String deleteUser(@RequestParam(name = "id") Integer id) {
        if (Boolean.TRUE.equals(userService.deleteUserMsg(id))) {
            logger.info("删除成功");
            return "redirect:findAll";
        }
        return "user-list";
    }

    /**
     * 用户注册
     *
     * @param user 注册类型
     * @return 登录界面
     */
    @LogAnnotation(name = "用户注册操作")
    @PostMapping("/register")
    public String userRegister(User user) throws IOException {
            //保存数据库的路径
            String sqlPath = null;
            //定义文件保存的本地路径
            String localPath="D:\\File\\";
            //定义 文件名
            String filename=null;
            if(!user.getFile().isEmpty()){
                //生成uuid作为文件名称
                String uuid = UUID.randomUUID().toString().replaceAll("-","");
                //获得文件类型（可以判断如果不是图片，禁止上传）
                String contentType=user.getFile().getContentType();
                //获得文件后缀名
                String suffixName=contentType.substring(contentType.indexOf("/")+1);
                //得到 文件名
                filename=uuid+"."+suffixName;
                logger.info(filename);
                //文件保存路径
                user.getFile().transferTo(new File(localPath+filename));
            }
            //把图片的相对路径保存至数据库
            sqlPath = "/images/"+filename;
            logger.info(sqlPath);
            user.setImg(sqlPath);
        if (Boolean.TRUE.equals(userService.userRegister(user))) {
            logger.info("注册成功");
            return "redirect:/login.jsp";
        } else {
            logger.info("注册失败");
            return "redirect:/userRegister.jsp";
        }
    }
}
