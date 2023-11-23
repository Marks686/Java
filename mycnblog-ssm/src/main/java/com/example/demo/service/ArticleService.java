package com.example.demo.service;

import com.example.demo.entity.Articleinfo;
import com.example.demo.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-11-18
 * Time: 20:43
 */
@Service
public class ArticleService {
    @Resource
    private ArticleMapper articleMapper;

    public int getArtCountByUid(Integer uid){
        return articleMapper.getArtCountByUid(uid);
    }

    public List<Articleinfo> getMyList(Integer uid){
        return articleMapper.getMyList(uid);
    }

    public int del(Integer id,Integer uid){
        return articleMapper.del(id,uid);
    }
}
