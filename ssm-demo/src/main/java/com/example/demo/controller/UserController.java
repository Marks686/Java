package com.example.demo.controller;

import com.example.demo.entity.Userinfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-26
 * Time: 15:26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getuserbyid")
    public Userinfo getUserById(Integer id){
        if (id == null){
            return null;
        }
        return userService.getUserById(id);
    }
}
