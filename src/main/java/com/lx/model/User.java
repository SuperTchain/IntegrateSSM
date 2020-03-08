package com.lx.model;

import java.io.Serializable;

public class User implements Serializable {
    //    用户ID
    private Integer id;
    //    用户名字
    private String name;
    //    用户电话号码
    private String number;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public User(Integer id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }
}
