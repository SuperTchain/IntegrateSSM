package com.lx.service;


import com.lx.model.Blog;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lx
 * @since 2020-06-10
 */
public interface BlogService  {

    /**
     * 查询所有博客
     * @return 博客列表
     */
    List<Blog> findAllBlog();
}
