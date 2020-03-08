package com.lx.ssmpj;

import org.springframework.stereotype.Service;

@Service
public class Springtest {

    //    测试方法
    public void sayHello() {
        System.out.println("hello ssm test!");
    }

    public void pringtHello() {
        sayHello();
    }
}
