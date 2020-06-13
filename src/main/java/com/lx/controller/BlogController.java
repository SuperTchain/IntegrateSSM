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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    private static Logger logger = Logger.getLogger(BlogController.class);

    /**
     * 引入service
     */
    @Autowired
    private BlogService blogService;

    /**
     * 管理员查询所有博客列表
     *
     * @param model 模型
     * @return 博客列表界面
     */
    @GetMapping("/findAllBlog")
    @LogAnnotation(name = "管理员查询所有博客", url = "/blog/findAllBlog")
    public String findAllBlogByAdmin(Model model) {
        List<Blog> list = blogService.findAllBlog();
        model.addAttribute("BlogList", list);
        logger.info("查询所有博客成功");
        return "admin/blog-list";
    }

    /**
     * 博主查询所有博客列表
     *
     * @param model 模型
     * @return 博客列表界面
     */
    @GetMapping("/findAllBlogByBlogAuthor")
    @LogAnnotation(name = "博主查询所有博客", url = "/blog/findAllBlogByBlogAuthor")
    public String findAllBlogByBlogAuthor(Model model) {
        List<Blog> list = blogService.findAllBlog();
        model.addAttribute("BlogList", list);
        logger.info("查询所有博客成功");
        return "blogAuthor/blogList";
    }

    /**
     * 游客查看博客列表
     * @param model
     * @return
     */
    @GetMapping("/tFindAllBlog")
    @LogAnnotation(name = "游客查看博客",url = "/blog/tFindAllBlog")
    public String tFindAllBlog(Model model){
        List<Blog> list = blogService.findAllBlog();
        model.addAttribute("BlogList", list);
        logger.info("查询所有博客成功");
        return "tourists/blogList";
    }

    /**
     * 管理员查看博客信息
     *
     * @param id 博客ID
     * @return 博客信息界面
     */
    @GetMapping("/view")
    public String viewBlog(Integer id,Model model) {
        Blog blog = blogService.findBlogById(id);
        model.addAttribute("Blog",blog);
        return "admin/viewBlog";
    }

    /**
     * 博主查看博客信息
     *
     * @param id 博客ID
     * @return 博客信息界面
     */
    @GetMapping("/viewByBlogAuthor")
    public String viewByBlogAuthor(Integer id,Model model) {
        Blog blog = blogService.findBlogById(id);
        model.addAttribute("Blog",blog);
        return "blogAuthor/viewBlog";
    }


    /**
     * 游客查看博客信息
     *
     * @param id 博客ID
     * @return 博客信息界面
     */
    @GetMapping("/tView")
    public String tViewBlog(Integer id,Model model) {
        Blog blog = blogService.findBlogById(id);
        model.addAttribute("Blog",blog);
        return "tourists/viewBlog";
    }

    /**
     * 跳转到添加博客界面
     * @return 添加博客界面
     */
    @GetMapping("/toAddBlog")
    public String toAddBlog(){
        return "blogAuthor/addBlog";
    }

    /**
     * 添加博客
     *
     * @param request 请求
     * @return 博客列表界面
     */
    @PostMapping("/addBlog")
    @LogAnnotation(name = "添加博客", url = "/blog/addBlog")
    public String addBlog(HttpServletRequest request,Blog blog) {
        logger.info(blog);
        //获取ckeditor编辑的内容
        String html = request.getParameter("blogContent");
        logger.info(html);
        Integer integer = blogService.addBlog(blog);
        if (integer==1){
            logger.info("添加成功");
        }
        return "redirect:/blog/findAllBlogByBlogAuthor";
    }

    /**
     * 跳转到修改博客界面
     * @param model 模型
     * @return 编辑博客界面
     */
    @GetMapping("/toEditByBlogAuthor")
    public String toEditByBlogAuthor(Integer id,Model model){
        Blog blogById = blogService.findBlogById(id);
        model.addAttribute("Blog",blogById);
        return "blogAuthor/editBlog";
    }

    /**
     * 编辑博客
     * @param blog 博客
     * @return 博客列表
     */
    @PostMapping("/updateBlog")
    @LogAnnotation(name = "博主修改博客",url = "/blog/updateBlog")
    public String  updateBlog(Blog blog){
        Integer integer = blogService.updateBlog(blog);
        if (integer==1){
            logger.info("更新成功");
        }
        return "redirect:/blog/findAllBlogByBlogAuthor";
    }


    /**
     * 删除博客
     *
     * @param id 博客ID
     * @return 博客列表界面
     */
    @GetMapping("/delete")
    @LogAnnotation(name = "删除博客", url = "/blog/delete")
    public String deleteBlog(Integer id) {
        Integer integer = blogService.deleteById(id);
        if (integer == 1) {

            logger.info("删除成功");
        }
        return "redirect:/blog/findAllBlog";
    }

    /**
     * 管理员模糊查询博客
     *
     * @param blogTitle  博客标题
     * @param blogAuthor 博主
     * @param model      模型
     * @return 博客界面
     */
    @PostMapping("/search")
    @LogAnnotation(name = "模糊查询博客", url = "/blog/search")
    public String search(String blogTitle, String blogAuthor, Model model) {
        if (blogTitle == null && blogAuthor == null) {
            return "redirect:findAllBlog";
        } else {
            List<Blog> list = blogService.search(blogTitle, blogAuthor);
            model.addAttribute("BlogList", list);
            logger.info("模糊查询成功");
            return "admin/blog-list";
        }
    }

    /**
     * 游客模糊查询博客
     *
     * @param blogTitle  博客标题
     * @param blogAuthor 博主
     * @param model      模型
     * @return 博客界面
     */
    @PostMapping("/tSearch")
    @LogAnnotation(name = "模糊查询博客", url = "/blog/tSearch")
    public String tSearch(String blogTitle, String blogAuthor, Model model) {
        if (blogTitle == null && blogAuthor == null) {
            return "redirect:tFindAllBlog";
        } else {
            List<Blog> list = blogService.search(blogTitle, blogAuthor);
            model.addAttribute("BlogList", list);
            logger.info("模糊查询成功");
            return "tourists/blogList";
        }
    }

    /**
     * 博主模糊查询博客
     *
     * @param blogTitle  博客标题
     * @param blogAuthor 博主
     * @param model      模型
     * @return 博客界面
     */
    @PostMapping("/searchByBlogAuthor")
    @LogAnnotation(name = "模糊查询博客", url = "/blog/searchByBlogAuthor")
    public String searchByBlogAuthor(String blogTitle, String blogAuthor, Model model) {
        if (blogTitle == null && blogAuthor == null) {
            return "redirect:findAllBlogByBlogAuthor";
        } else {
            List<Blog> list = blogService.search(blogTitle, blogAuthor);
            model.addAttribute("BlogList", list);
            logger.info("模糊查询成功");
            return "blogAuthor/blogList";
        }
    }


    /**
     * 跳转到我的博客界面
     * @param model 模型
     * @param session 会话
     * @return 我的博客界面
     */
    @GetMapping("/toMyBlog")
    public String toMyBlog(Model model, HttpSession session){
        String blogAuthor= (String) session.getAttribute("username");
        logger.info(blogAuthor);
        List<Blog> list = blogService.findBlogByName(blogAuthor);
        logger.info(list);
        model.addAttribute("BlogList",list);
        return "blogAuthor/myBlog";
    }
}
