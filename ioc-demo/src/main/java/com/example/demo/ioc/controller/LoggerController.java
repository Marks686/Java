package com.example.demo.ioc.controller;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;
@Slf4j
@RestController
public class LoggerController {
//    private static Logger logger = LoggerFactory.getLogger(LoggerController.class);

//    @PostConstruct
//    public void print(){
//        System.out.println("打印日志");
//        logger.info("我是日志框架打印的日志");
//        logger.error("error");
//        logger.warn("warn");
//        logger.debug("debug");
//        logger.trace("trace");
//    }

    @PostConstruct
    public void print(){
        System.out.println("打印日志");
        log.info("我是日志框架打印的日志");
        log.error("error");
        log.warn("warn");
        log.debug("debug");
        log.trace("trace");
    }
}
