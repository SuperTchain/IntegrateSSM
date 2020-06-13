package com.lx.dao;

import com.lx.model.Comments;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsDao {
    /**
     * 添加评论
     * @param comments 评论实体
     * @return 添加结果
     */
    Integer addComent(Comments comments);

    /**
     * 查询该文章下的所有评论
     * @param id id
     * @return 查询结果
     */
    List<Comments> findCommentsById(Integer id);

    /**
     * 查询博主参与的所有评论
     * @param username 博主名称
     * @return 查询结果
     */
    List<Comments> findCommentsByName(String username);
}
