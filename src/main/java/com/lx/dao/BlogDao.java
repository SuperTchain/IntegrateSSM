package com.lx.dao;


import com.lx.model.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogDao  {

    /**
     * 查询所有博客列表
     * @return 博客列表
     */
    List<Blog> findAllBlog();

    /**
     * 模糊查询博客
     * @param blogTitle
     * @param blogAuthor
     * @return
     */
    List<Blog> search(@Param("blogTitle") String blogTitle,@Param("blogAuthor") String blogAuthor);

    /**
     * 根据id删除博客
     * @param id id
     * @return 删除结果
     */
    Integer deleteById(Integer id);

    /**
     * 根据博客id查询博客信息
     * @param id 博客id
     * @return 博客信息
     */
    Blog findBlogById(Integer id);
}
