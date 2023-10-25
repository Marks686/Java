package com.example.demo.mapper;

import com.example.demo.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-25
 * Time: 23:12
 */
@Mapper
public interface UserMapper {
    Userinfo getUserById(@Param("user_id") Integer id);
}
