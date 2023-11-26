package com.example.demo.mapper;

import com.example.demo.entity.Articleinfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-11-18
 * Time: 20:41
 */
@SpringBootTest
class ArticleMapperTest {

    @Resource
    private ArticleMapper articleMapper;

    @Test
    void getArtCountByUid() {
        int result = articleMapper.getArtCountByUid(1);
        System.out.println("文章总数: " + result);
    }

    @Test
    void getListByPage() {
        List<Articleinfo> list = articleMapper.getListByPage(3,0);
        System.out.println(list);
        System.out.println("--------------------------");
        List<Articleinfo> list2= articleMapper.getListByPage(3,3);
        System.out.println(list2);
    }
}