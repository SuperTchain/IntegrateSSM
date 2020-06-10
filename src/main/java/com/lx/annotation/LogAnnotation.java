package com.lx.annotation;


import org.springframework.stereotype.Component;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * @author lx
 * 自定义日志记录注解
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    //详细操作
    String name() default "";
    //操作地址
    String url() default "";
}


