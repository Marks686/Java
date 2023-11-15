package com.example.demo.service;

import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-11-12
 * Time: 18:52
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    public Integer add(UserInfo userInfo){
        int result = userMapper.add(userInfo);
        System.out.println("用户添加:" + result);
        return result;
    }

}
