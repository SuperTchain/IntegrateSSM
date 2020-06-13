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

    /**
     * 模糊查询结果
     * @param blogTitle 博客标题
     * @param blogAuthor 博主
     * @return 博客列表
     */
    List<Blog> search(String blogTitle, String blogAuthor);

    /**
     * 删除博客
     * @param id 博客id
     * @return 删除结果
     */
    Integer deleteById(Integer id);

    /**
     * 根据id查询博客信息
     * @param id 博客id
     * @return 博客信息
     */
    Blog findBlogById(Integer id);

    /**
     * 添加博客
     * @param blog 博客实体
     */
    Integer addBlog(Blog blog);

    /**
     * 更新博客
     * @param blog
     */
    Integer updateBlog(Blog blog);

    /**
     * 根据名称查询博客
     * @param blogAuthor 名称
     * @return 博客列表
     */
    List<Blog> findBlogByName(String blogAuthor);
}
