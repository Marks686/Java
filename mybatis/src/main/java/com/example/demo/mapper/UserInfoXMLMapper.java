package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoXMLMapper {

    List<UserInfo> selectAll();

    Integer insert(UserInfo userInfo);
}
