package com.lx.controller;

import com.lx.annotation.LogAnnotation;
import com.lx.model.Blog;
import com.lx.service.BlogService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName BlogController
 * @Description TODO
 * @Author ASUS
 * @Date 2020/6/10 21:50
 * @Version 1.0
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
    /**
     * 引入日志
     */
    private static Logger logger=Logger.getLogger(BlogController.class);

    /**
     * 引入service
     */
    @Autowired
    private BlogService blogService;

    /**
     * 跳转到博客列表界面
     * @param model 模型
     * @return 博客列表界面
     */
    @GetMapping("/findAllBlog")
    @LogAnnotation(name = "查询所有博客",url = "/blog/findAllBlog")
    public String findAllLog(Model model){
        List<Blog> list = blogService.findAllBlog();
        model.addAttribute("BlogList",list);
        return "blog-list";
    }


    /**
     * 查看博客信息
     * @param id 博客ID
     * @return 博客信息界面
     */
    @GetMapping("/view")
    public String viewBlog(Integer id){
        return "view-blog";
    }


    /**
     * 添加博客
     * @param request 请求
     * @return 博客列表界面
     */
    @PostMapping("/addBlog")
    public String addBlog(HttpServletRequest request,String blogTitle,String blogDesc){
        String html = request.getParameter("content");

        System.out.println(html+"  "+blogTitle+"  "+blogDesc);
        return "blog-list";
    }
}
