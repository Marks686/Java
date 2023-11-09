package com.example.demo.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-11-08
 * Time: 21:59
 */
public class LoginInterceptor implements HandlerInterceptor {
    // 此方法返回一个boolean 如果为true 表示验证成功
    // 如果为 false 表示验证失败,                  后面的流程不能执行了
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 用户登录业务判断
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userinfo") != null){
            // 用户已经登录了
            return true;
        }
        // 没有登录 跳转到登录页面 or 返回401/403 没有权限的状态码
        response.sendRedirect("/login.html");
//        response.setStatus(403);
        return false;
    }
}
