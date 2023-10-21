package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-21
 * Time: 12:04
 */
@Controller
@ResponseBody
@RequestMapping("/art")
@Slf4j
public class ArticleController {

//    // 1. 得到日志对象
//    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @RequestMapping("/hi")
    public String sayHi(){
        log.trace("我是 slf4j 的 trace");
        log.debug("我是 slf4j 的 debug");
        log.info("我是 slf4j 的 iNfo");
        return "Hi,Article Info.";
    }
}
