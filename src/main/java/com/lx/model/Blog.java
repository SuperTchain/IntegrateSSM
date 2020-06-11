package com.lx.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lx.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Blog
 * @Description TODO
 * @Author ASUS
 * @Date 2020/6/10 22:42
 * @Version 1.0
 */
public class Blog implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("blogTitle")
    private String blogTitle;

    @TableField("blogDesc")
    private String blogDesc;

    @TableField("blogContent")
    private String blogContent;

    @TableField("blogPublishTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date blogPublishTime;

    private String blogPublishTimeToStr;

    @TableField("blogOrigin")
    private Integer blogOrigin;

    private String blogOriginToStr;


    @TableField("blogAuthor")
    private String blogAuthor;

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogDesc='" + blogDesc + '\'' +
                ", blogContent='" + blogContent + '\'' +
                ", blogPublishTime=" + blogPublishTime +
                ", blogPublishTimeToStr='" + blogPublishTimeToStr + '\'' +
                ", blogOrigin=" + blogOrigin +
                ", blogOriginToStr='" + blogOriginToStr + '\'' +
                ", blogAuthor='" + blogAuthor + '\'' +
                '}';
    }

    public String getBlogOriginToStr() {
        if (blogOrigin!=null){
            if (blogOrigin==1){
                blogOriginToStr="原创";
            }else {
                blogOriginToStr="非原创";
            }
        }
        return blogOriginToStr;
    }

    public void setBlogOriginToStr(String blogOriginToStr) {
        this.blogOriginToStr = blogOriginToStr;
    }

    public String getBlogAuthor() {
        return blogAuthor;
    }

    public void setBlogAuthor(String blogAuthor) {
        this.blogAuthor = blogAuthor;
    }

    public String getBlogPublishTimeToStr() {
        if (blogPublishTime!=null){
            blogPublishTimeToStr= DateUtils.dateToStr(blogPublishTime,"yyyy-MM-dd HH:mm:ss");
        }
        return blogPublishTimeToStr;
    }

    public void setBlogPublishTimeToStr(String blogPublishTimeToStr) {
        this.blogPublishTimeToStr = blogPublishTimeToStr;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogDesc() {
        return blogDesc;
    }

    public void setBlogDesc(String blogDesc) {
        this.blogDesc = blogDesc;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public Date getBlogPublishTime() {
        return blogPublishTime;
    }

    public void setBlogPublishTime(Date blogPublishTime) {
        this.blogPublishTime = blogPublishTime;
    }

    public Integer getBlogOrigin() {
        return blogOrigin;
    }

    public void setBlogOrigin(Integer blogOrigin) {
        this.blogOrigin = blogOrigin;
    }
}
