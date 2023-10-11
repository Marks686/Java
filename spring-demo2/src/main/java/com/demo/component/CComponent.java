package com.demo.component;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-11
 * Time: 18:21
 */
@Component
public class CComponent {
    @PostConstruct
    public void postConstruct(){
        System.out.println("执行了 C 对象的 PostConstruct 方法");
    }
}
