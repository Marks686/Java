package com.example.demo.service;

import com.example.demo.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
