package com.example.demo.service;

import com.example.demo.entity.Userinfo;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-26
 * Time: 15:19
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Userinfo getUserById(Integer id){
        return userMapper.getUserById(id);
    }
}
