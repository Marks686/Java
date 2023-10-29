package com.example.demo.mapper;

import com.example.demo.entity.Userinfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-29
 * Time: 19:18
 */
@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void getUserById() {
        // 单元测试的业务代码
        Userinfo userinfo = userMapper.getUserById(1);
        System.out.println(userinfo);
        Assertions.assertEquals("admin",userinfo.getUsername());
    }

    @Test
    void getAll() {
        List<Userinfo> list = userMapper.getAll();
        Assertions.assertEquals(1,list.size());
    }
}