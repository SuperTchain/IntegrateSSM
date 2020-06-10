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
 * @ClassName Log
 * @Description TODO
 * @Author ASUS
 * @Date 2020/6/10 12:04
 * @Version 1.0
 */
@TableName("log")
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("userName")
    private String userName;

    @TableField("operation")
    private String operation;

    @TableField("operationUrl")
    private String operationUrl;

    @TableField("operationTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date operationTime;


    private String operationTimeToStr;

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", operation='" + operation + '\'' +
                ", operationUrl='" + operationUrl + '\'' +
                ", operationTime=" + operationTime +
                ", operationTimeToStr='" + operationTimeToStr + '\'' +
                '}';
    }

    public String getOperationTimeToStr() {
        if (operationTime != null) {
            operationTimeToStr = DateUtils.dateToStr(operationTime, "yyyy-MM-dd HH:mm:ss");
        }
        return operationTimeToStr;
    }

    public void setOperationTimeToStr(String operationTimeToStr) {
        this.operationTimeToStr = operationTimeToStr;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperationUrl() {
        return operationUrl;
    }

    public void setOperationUrl(String operationUrl) {
        this.operationUrl = operationUrl;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }
}
