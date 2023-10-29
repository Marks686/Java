package com.example.demo.mapper;

import com.example.demo.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 根据用户 id 查询用户信息
 * Date: 2023-10-25
 * Time: 23:12
 */
@Mapper
public interface UserMapper {
    Userinfo getUserById(@Param("userId") Integer userId);

    List<Userinfo> getAll();
}
