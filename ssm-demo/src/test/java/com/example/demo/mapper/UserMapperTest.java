package com.example.demo.mapper;

import com.example.demo.entity.Userinfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-29
 * Time: 19:18
 */
@SpringBootTest // 表明当前单元测试是运行在 Spring Boot 环境中的
//@Transactional
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void getUserById() {
        // 单元测试的业务代码
        Userinfo userinfo = userMapper.getUserById(1);
        System.out.println(userinfo);
//        Assertions.assertEquals("admin",userinfo.getUsername());
    }

    @Test
    void getAll() {
        List<Userinfo> list = userMapper.getAll();
        System.out.println(list);
    }

    @Test
    void add() {
        Userinfo userinfo = new Userinfo();
//        userinfo.setUsername("重八");
        userinfo.setPassword("1234567");
        userinfo.setCreatetime(LocalDateTime.now());
        userinfo.setUpdatetime(LocalDateTime.now());
        // 调用 mybatis 添加方法执行添加操作
        int result = userMapper.add(userinfo);
        System.out.println("添加: " + result);

        int uid = userinfo.getId();
        System.out.println("用户ID: " + uid);
        Assertions.assertEquals(1,result);
    }

    @Test
    void addGetId() {
        Userinfo userinfo = new Userinfo();
//        userinfo.setUsername("井七");
        userinfo.setPassword("1234567");
        userinfo.setCreatetime(LocalDateTime.now());
        userinfo.setUpdatetime(LocalDateTime.now());
        // 调用 mybatis 添加方法执行添加操作
        int result = userMapper.addGetId(userinfo);
        System.out.println("添加: " + result);

        int uid = userinfo.getId();
        System.out.println("用户ID: " + uid);
        Assertions.assertEquals(1,result);
    }

    @Test
    void upUserName() {
        // 构建测试数据
        Userinfo userinfo = new Userinfo();
        userinfo.setId(5);
//        userinfo.setUsername("老老六");
        int result = userMapper.upUserName(userinfo);
        System.out.println("修改: " + result);
        Assertions.assertEquals(1,result);
    }

    @Test
    void delById() {
        Integer id = 4;
        int result = userMapper.delById(id);
        System.out.println("删除: " + result);
        Assertions.assertEquals(1,result);

    }

    @Test
    void getUserByName() {
        List<Userinfo> list = userMapper.getUserByName("张三");
        System.out.println("查询: " + list.size());

    }

    @Test
    void getListByOrder() {
        List<Userinfo> list = userMapper.getListByOrder("desc");
        System.out.println(list);
    }

    @Test
    void login() {
        String username = "admin";
        String password = "' or 1 ='1"; // sql 注入[安全问题]
        Userinfo userinfo = userMapper.login(username,password);
        System.out.println("登录状态: " + (userinfo==null ? "失败" : "成功"));
    }

    @Test
    void getListByName() {
        String username = "m";
        List<Userinfo> list = userMapper.getListByName(username);
        System.out.println("list: " + list);
    }
}