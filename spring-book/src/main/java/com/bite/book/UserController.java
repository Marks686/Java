package com.bite.book;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/login")
    public Boolean login(String userName, String password, HttpSession session){
        //校验参数
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)){
            return false;
        }
        //验证账号密码是否正确
        if ("admin".equals(userName) && "admin".equals(password)){
            //正确
            session.setAttribute("userName",userName);
            return true;
        }
        return false;
    }
}
