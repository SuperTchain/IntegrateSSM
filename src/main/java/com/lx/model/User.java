package com.lx.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;


/**
 * @author lx
 */
public class User implements Serializable {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户名字
     */
    private String name;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户个人简介
     */
    private String userdesc;
    /**
     * 用户注册日期
     */
    private Date registdate;
    /**
     * 用户注册地址
     */
    private String address;
    /**
     * 用户头像
     */
    private Blob chathead;
    /**
     * 用户电话号码
     */
    private String phonenumber;
    /**
     * 用户邮件地址
     */
    private String emailaddress;
    /**
     * 用户爱好
     */
    private String hobbys;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", userdesc='" + userdesc + '\'' +
                ", registdate=" + registdate +
                ", address='" + address + '\'' +
                ", chathead=" + chathead +
                ", phonenumber='" + phonenumber + '\'' +
                ", emailaddress='" + emailaddress + '\'' +
                ", hobbys='" + hobbys + '\'' +
                '}';
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistdate() {
        return registdate;
    }

    public void setRegistdate(Date registdate) {
        this.registdate = registdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Blob getChathead() {
        return chathead;
    }

    public void setChathead(Blob chathead) {
        this.chathead = chathead;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getHobbys() {
        return hobbys;
    }

    public void setHobbys(String hobbys) {
        this.hobbys = hobbys;
    }

    public String getUserdesc() {
        return userdesc;
    }

    public void setUserdesc(String userdesc) {
        this.userdesc = userdesc;
    }
}
