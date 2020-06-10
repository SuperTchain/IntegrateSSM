package com.lx.utils;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginIntercepter
 * @Description TODO
 * @Author ASUS
 * @Date 2020/5/20 0:29
 * @Version 1.0
 */
public class LoginIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute("username")==null){
            response.sendRedirect(request.getContextPath()+"/login");
        }
        return true;
    }
}
