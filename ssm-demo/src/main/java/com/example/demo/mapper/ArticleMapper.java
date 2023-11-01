package com.example.demo.mapper;

import com.example.demo.entity.vo.ArticleinfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-11-01
 * Time: 14:51
 */
@Mapper
public interface ArticleMapper {

    ArticleinfoVO getById(@Param("id") Integer id);
}
