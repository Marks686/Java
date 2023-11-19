package com.example.demo.service;

import com.example.demo.entity.Userinfo;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-11-18
 * Time: 18:35
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public int reg(Userinfo userinfo){
        return userMapper.reg(userinfo);
    }

    public Userinfo getUserByName(String username){
        return userMapper.getUserByName(username);
    }
}
