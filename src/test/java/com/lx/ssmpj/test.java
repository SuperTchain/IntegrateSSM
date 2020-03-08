package com.lx.ssmpj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class test {
    @Test
    public void pringtHello(){
//        获取配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
//        获取方法注意方法名一定要小写！！！！
        Springtest ts= (Springtest) applicationContext.getBean("springtest");
//        调用方法
        ts.pringtHello();
    }
}

