package com.lx.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lx.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author lx
 * @since 2020-06-13
 */
@TableName("comments")
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("comment")
    private String comment;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("commentTime")
    private Date commentTime;

    private String commentTimeToStr;

    @TableField("critics")
    private String critics;

    @TableField("commentArticle")
    private Integer commentArticle;

    private Blog blog;

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", commentTime=" + commentTime +
                ", commentTimeToStr='" + commentTimeToStr + '\'' +
                ", critics='" + critics + '\'' +
                ", commentArticle=" + commentArticle +
                ", blog=" + blog +
                '}';
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentTimeToStr() {
        if (commentTime!=null){
            commentTimeToStr= DateUtils.dateToStr(commentTime,"yyyy-MM-dd HH:mm:ss");
        }
        return commentTimeToStr;
    }

    public void setCommentTimeToStr(String commentTimeToStr) {
        this.commentTimeToStr = commentTimeToStr;
    }

    public String getCritics() {
        return critics;
    }

    public void setCritics(String critics) {
        this.critics = critics;
    }

    public Integer getCommentArticle() {
        return commentArticle;
    }

    public void setCommentArticle(Integer commentArticle) {
        this.commentArticle = commentArticle;
    }
}
