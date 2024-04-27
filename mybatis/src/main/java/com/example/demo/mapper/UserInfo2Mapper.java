package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 动态SQL练习
 */
@Mapper
public interface UserInfo2Mapper {
    /**
     * 性别字段为空
     * @param userInfo
     * @return
     */
    @Insert("<script>" +
            "insert into userinfo (username,password,age," +
            "<if test='gender!=null'>gender,</if>" +
            "phone)" +
            "values(#{username},#{password},#{age}," +
            "<if test='gender!=null'>#{gender},</if>" +
            "#{phone})" +
            "</script>")
    Integer insert(UserInfo userInfo);

    Integer insertByXML(UserInfo userInfo);

    List<UserInfo> selectByCondition(UserInfo userInfo);

    /**
     * 注解方式
     * @param userInfo
     * @return
     */
    @Select("<script>" +
            "select * from userinfo" +
            "        <where>" +
            "            <if test=\"username!=null\">" +
            "                username = #{username}" +
            "            </if>" +
            "            <if test=\"age!=null\">" +
            "                and age = #{age}" +
            "            </if>" +
            "            <if test=\"gender!=null\">" +
            "                and gender = #{gender}" +
            "            </if>" +
            "        </where>" +
            "</script>")
    List<UserInfo> selectByCondition3(UserInfo userInfo);

    Integer updateByCondition(UserInfo userInfo);


//    /**
//     * 使用set标签
//     * @param userInfo
//     * @return
//     */
//    Integer updateByCondition2(UserInfo userInfo);


    Integer batchDelete(@Param("ids") List<Integer> ids);
}
