package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-11-18
 * Time: 20:37
 */
@Mapper
public interface ArticleMapper {

    int getArtCountByUid(@Param("uid") Integer uid);
}
