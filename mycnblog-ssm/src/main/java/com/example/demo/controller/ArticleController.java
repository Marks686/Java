package com.example.demo.controller;

import com.example.demo.common.AjaxResult;
import com.example.demo.common.UserSessionUtils;
import com.example.demo.entity.Articleinfo;
import com.example.demo.entity.Userinfo;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-11-22
 * Time: 22:57
 */
@RestController
@RequestMapping("/art")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/mylist")
    public AjaxResult getMyList(HttpServletRequest request){
        Userinfo userinfo = UserSessionUtils.getUser(request);
        if (userinfo == null){
            return AjaxResult.fail(-1,"非法请求");
        }
        List<Articleinfo> list = articleService.getMyList(userinfo.getId());
        return AjaxResult.success(list);
    }

    @RequestMapping("/del")
    public AjaxResult del(HttpServletRequest request,Integer id){
        if (id == null || id <= 0){
            // 参数有误
            return AjaxResult.fail(-1,"参数异常");
        }
        Userinfo user = UserSessionUtils.getUser(request);
        if (user == null){
            return AjaxResult.fail(-2,"用户未登录");
        }
        return AjaxResult.success(articleService.del(id,user.getId()));
    }

    @RequestMapping("/detail")
    public AjaxResult getDetail(Integer id){
        if (id == null || id <= 0){
            return AjaxResult.fail(-1,"非法参数");
        }
        return AjaxResult.success(articleService.getDetail(id));
    }

    @RequestMapping("/incr-rcount")
    public AjaxResult incrRCount(Integer id){
        if (id != null && id > 0){
            return AjaxResult.success(articleService.incrRCount(id));
        }
        return AjaxResult.success(-1,"未知错误");
    }

    @RequestMapping("/add")
    public AjaxResult add(HttpServletRequest request,Articleinfo articleinfo){
        // 1.非空效验
        if (articleinfo == null || !StringUtils.hasLength(articleinfo.getTitle()) ||
                !StringUtils.hasLength(articleinfo.getContent())){
            // 非法参数
            return AjaxResult.fail(-1,"非法参数");
        }
        // 2.数据库添加操作
        // a.得到当前登录用户的 uid
        Userinfo userinfo = UserSessionUtils.getUser(request);
        if (userinfo == null || userinfo.getId() <= 0){
            // 无效用户
            return AjaxResult.fail(-2,"无效的登录用户");
        }
        articleinfo.setUid(userinfo.getId());
        // b.添加数据库并返回结果
        return AjaxResult.success(articleService.add(articleinfo));
    }


    @RequestMapping("/update")
    public AjaxResult update(HttpServletRequest request,Articleinfo articleinfo){
        // 非空效验
        if (articleinfo == null || !StringUtils.hasLength(articleinfo.getTitle()) ||
                !StringUtils.hasLength(articleinfo.getContent()) ||
                articleinfo.getId() == null){
            // 非法参数
            return AjaxResult.fail(-1,"非法参数");
        }
        // 得到当前登录用户的id
        Userinfo userinfo = UserSessionUtils.getUser(request);
        if (userinfo == null || userinfo.getId() == null){
            // 无效用户
            return AjaxResult.fail(-2,"无效用户");
        }
        // 核心代码(解决了修改文章归属人判定的问题)
        articleinfo.setUid(userinfo.getId());
        articleinfo.setUpdatetime(LocalDateTime.now());
        return AjaxResult.success(articleService.update(articleinfo));
    }
}


















































