package com.lx.controller;

import com.lx.annotation.LogAnnotation;
import com.lx.model.Comments;
import com.lx.service.BlogService;
import com.lx.service.CommentsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName CommentsController
 * @Description TODO
 * @Author ASUS
 * @Date 2020/6/13 15:24
 * @Version 1.0
 */
@Controller
@RequestMapping("/comments")
public class CommentsController {

    /**
     * 引入日志
     */
    private static Logger logger=Logger.getLogger(CommentsController.class);

    /**
     * 引入service
     */
    @Autowired
    private CommentsService commentsService;

    @Autowired
    private BlogService blogService;

    /**
     * 添加评论
     * @param comments 评论实体
     * @return 主界面
     */
    @PostMapping("/addComment")
    @LogAnnotation(name = "添加评论",url = "/comments/addComment")
    public String addComment(Comments comments){
        logger.info(comments.getComment());
        Integer integer = commentsService.addComment(comments);
        if (integer==1){
            logger.info("添加评论成功");
        }
        return "redirect:/user/returnBlogAuthor";
    }

    /**
     * 跳转到管理评论
     * @param model 模型
     * @return 管理评论界面
     */
    @GetMapping("/toMyComments")
    @LogAnnotation(name = "管理评论",url = "/comments/toMyComments")
    public String toMyComments(Model model,Integer id, HttpSession session){
        String username = (String) session.getAttribute("username");
        //查询我参与的评论
        List<Comments> list = commentsService.findCommentsByName(username);
        logger.info(list);
        //根据博客id查询博客
        model.addAttribute("myJoinComments",list);
        return "blogAuthor/myComments";
    }
}
