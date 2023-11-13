package com.example.demo.mapper;

import com.example.demo.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-11-12
 * Time: 18:44
 */
@Mapper
public interface UserMapper {
    int add(UserInfo userInfo);
}
