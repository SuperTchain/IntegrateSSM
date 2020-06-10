package com.lx.model;

import java.io.Serializable;

/**
 * @ClassName UserAddress
 * @Description TODO
 * @Author ASUS
 * @Date 2020/5/8 10:21
 * @Version 1.0
 */
public class UserAddress implements Serializable {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户家庭地址
     */
    private String homeaddress;
    /**
     * 用户工作地址
     */
    private String workaddress;
    /**
     * 用户id
     */
    private Integer userid;

    @Override
    public String toString() {
        return "UserAddress{" +
                "id=" + id +
                ", homeaddress='" + homeaddress + '\'' +
                ", workaddress='" + workaddress + '\'' +
                ", userid=" + userid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress;
    }

    public String getWorkaddress() {
        return workaddress;
    }

    public void setWorkaddress(String workaddress) {
        this.workaddress = workaddress;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
