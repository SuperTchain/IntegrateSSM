package com.lx.dao;


import com.lx.model.Blog;

import java.util.List;

public interface BlogDao  {

    /**
     * 查询所有博客列表
     * @return 博客列表
     */
    List<Blog> findAllBlog();
}
