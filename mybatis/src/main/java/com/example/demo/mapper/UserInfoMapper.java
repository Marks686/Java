package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserInfoMapper {

    /**
     * 结果映射
     * 方法一：对字段进行重命名
     * @return
     */
    @Select("select id, username, password, age, gender, phone," +
            " delete_flag as deleteFlag, create_time as createTime, update_time as updateTime" +
            " from userinfo")
    List<UserInfo> selectAll();


    /**
     * 结果映射
     * 方法二：使用注解的方式
     * @return
     */
    @Results(id = "BaseMap",value = {
            @Result(column = "delete_flag",property = "deleteFlag"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "update_time",property = "updateTime"),
    })
    @Select("select * from userinfo")
    List<UserInfo> selectAll2();




    @ResultMap(value = "BaseMap")
    @Select("select * from userinfo where id= #{id}")
    UserInfo selectOne(Integer id);


    /**
     * 结果映射
     * 方法三：使用配置的方式，自动转驼峰
     * @return
     */
    @Select("select * from userinfo")
    List<UserInfo> selectAll3();

    @Select("select * from userinfo where id= #{userId}")
    UserInfo selectOne2(@Param("userId") Integer id);

    //返回自增id
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into userinfo (username,password,age,gender,phone)" +
            "values(#{username},#{password},#{age},#{gender},#{phone})")
    Integer insert(UserInfo userInfo);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into userinfo (username,password,age,gender,phone)" +
            "values(#{userInfo.username},#{userInfo.password},#{userInfo.age},#{userInfo.gender},#{userInfo.phone})")
    Integer insert2(@Param("userInfo") UserInfo userInfo);

    @Select("delete from userinfo where id = #{id}")
    Integer delete(Integer id);

    @Update("update userinfo set age = #{age} where id = #{id}")
    Integer update(UserInfo id);
}
