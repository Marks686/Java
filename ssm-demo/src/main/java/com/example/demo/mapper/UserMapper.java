package com.example.demo.mapper;

import com.example.demo.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-25
 * Time: 23:12
 */
@Mapper
public interface UserMapper {
    /* 根据id查询用户信息 */
    Userinfo getUserById(@Param("userId") Integer userId);

    List<Userinfo> getUserByName(@Param("username") String username);

    /* 查询全部 */
    List<Userinfo> getAll();

    /* 添加用户对象 */
    int add(Userinfo userinfo);

    /* 添加用户 并返回用户 id*/
    int addGetId(Userinfo userinfo);

    /* 修改用户 */
    int upUserName(Userinfo userinfo);

    /* 根据用户id 删除 用户信息*/
    int delById(@Param("id") Integer id);

    /* 在查询的时候根据 id 大小排序进行显示 */
    List<Userinfo> getListByOrder(@Param("order") String order);

    /* 登录 */
    Userinfo login(@Param("username") String username,
                   @Param("password") String password);

    List<Userinfo> getListByName(@Param("username") String username);
}

