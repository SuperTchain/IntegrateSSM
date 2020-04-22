package com.lx.model;

import java.io.Serializable;


public class User implements Serializable {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户Id
     */
    private String name;
    /**
     * 数量
     */
    private Integer number;

    /**
     * 用户密码
     *
     * @return
     */
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", password='" + password + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
