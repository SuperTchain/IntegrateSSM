package com.lx.service.impl;

import com.lx.dao.BlogDao;
import com.lx.model.Blog;
import com.lx.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BlogServiceImpl
 * @Description TODO
 * @Author ASUS
 * @Date 2020/6/10 22:47
 * @Version 1.0
 */
@Service
public class BlogServiceImpl implements BlogService {
    /**
     * 引入dao
     */
    @Autowired
    private BlogDao blogDao;

    /**
     * 查询所有博客
     * @return 查询结果
     */
    @Override
    public List<Blog> findAllBlog() {
        return blogDao.findAllBlog();
    }

    /**
     * 模糊查询博客
     * @param blogTitle 博客标题
     * @param blogAuthor 博主
     * @return 博客列表
     */
    @Override
    public List<Blog> search(String blogTitle, String blogAuthor) {
        return blogDao.search(blogTitle,blogAuthor);
    }

    /**
     * 删除博客
     * @param id 博客id
     */
    @Override
    public Integer deleteById(Integer id) {
        return blogDao.deleteById(id);
    }

    /**
     * 根据博客id查看博客信息
     * @param id 博客id
     * @return 博客
     */
    @Override
    public Blog findBlogById(Integer id) {
        return blogDao.findBlogById(id);
    }

    /**
     * 添加博客
     * @param blog 博客实体
     */
    @Override
    public Integer addBlog(Blog blog) {
        return blogDao.addBlog(blog);
    }

    /**
     * 添加博客
     * @param blog 修改的博客信息
     * @return 更新结果
     */
    @Override
    public Integer updateBlog(Blog blog) {
        return blogDao.updateBlog(blog);
    }

    /**
     * 根据名称查询博客
     * @param blogAuthor 名称
     * @return 博客列表
     */
    @Override
    public List<Blog> findBlogByName(String blogAuthor) {
        return blogDao.findBlogByName(blogAuthor);
    }
}
