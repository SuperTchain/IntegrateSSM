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
}
