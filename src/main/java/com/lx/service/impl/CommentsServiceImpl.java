package com.lx.service.impl;

import com.lx.dao.CommentsDao;
import com.lx.model.Comments;
import com.lx.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CommentsServiceImpl
 * @Description TODO
 * @Author ASUS
 * @Date 2020/6/13 15:26
 * @Version 1.0
 */
@Service
public class CommentsServiceImpl implements CommentsService {

    /**
     * 引入dao
     */
    @Autowired
    private CommentsDao commentsDao;

    /**
     * 添加评论
     * @param comments 评论实体
     * @return 添加结果
     */
    @Override
    public Integer addComment(Comments comments) {
        return commentsDao.addComent(comments);
    }

    /**
     * 查询所有该文章下的评论
     * @param id id
     * @return 查询结果
     */
    @Override
    public List<Comments> findCommentsById(Integer id) {
        return commentsDao.findCommentsById(id);
    }

    /**
     * 查询博主参与的所有评论
     * @param username 博主名称
     * @return 查询结果
     */
    @Override
    public List<Comments> findCommentsByName(String username) {
        return commentsDao.findCommentsByName(username);
    }
}
