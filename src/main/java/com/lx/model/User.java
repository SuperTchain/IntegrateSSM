package com.lx.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lx.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.List;


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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date registdate;

    /**
     * 将将date转化为String显示在页面上
     */
    private String registdateToStr;
    /**
     * 用户注册地址
     */
    private String address;
    /**
     * 用户头像
     */
    private String img;
    /**
     * 上传文件
     */
    private MultipartFile file;
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

    /**
     * 用户性别
     */
    private String gender;

    /**
     * 用户地址
     */
    private UserAddress addressesList;

    /**
     * 用户角色
     */
    private String role;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", userdesc='" + userdesc + '\'' +
                ", registdate=" + registdate +
                ", registdateToStr='" + registdateToStr + '\'' +
                ", address='" + address + '\'' +
                ", img='" + img + '\'' +
                ", file=" + file +
                ", phonenumber='" + phonenumber + '\'' +
                ", emailaddress='" + emailaddress + '\'' +
                ", hobbys='" + hobbys + '\'' +
                ", gender='" + gender + '\'' +
                ", addressesList=" + addressesList +
                ", role='" + role + '\'' +
                '}';
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserAddress getAddressesList() {
        return addressesList;
    }

    public void setAddressesList(UserAddress addressesList) {
        this.addressesList = addressesList;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRegistdateToStr() {
        if (registdate != null) {
            registdateToStr = DateUtils.dateToStr(registdate, "yyyy-MM-dd HH:mm:ss");
        }
        return registdateToStr;
    }

    public void setRegistdateToStr(String registdateToStr) {
        this.registdateToStr = registdateToStr;
    }
}
