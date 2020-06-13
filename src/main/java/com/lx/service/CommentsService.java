package com.lx.service;

import com.lx.model.Comments;

import java.util.List;

public interface CommentsService {
    /**
     * 添加评论
     * @param comments
     * @return
     */
    Integer addComment(Comments comments);

    /**
     * 查询所有该文章评论
     * @param id id
     * @return 查询结果
     */
    List<Comments> findCommentsById(Integer id);

    /**
     * 查询博主参与的评论
     * @param username 博主名称
     * @return 查询结果
     */
    List<Comments> findCommentsByName(String username);
}
