package com.example.demo.mapper;

import com.example.demo.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-11-18
 * Time: 18:09
 */
@Mapper
public interface UserMapper {
    // 注册
    int reg(Userinfo userinfo);

    // 根据用户查询 userinfo 对象
    Userinfo getUserByName(@Param("username") String username);

    // 根据用户id 查询用户信息
    Userinfo getUserById(@Param("id") Integer id);
}
