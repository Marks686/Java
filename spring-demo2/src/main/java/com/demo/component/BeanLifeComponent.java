package com.demo.component;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-11
 * Time: 16:42
 */
public class BeanLifeComponent implements BeanNameAware {

    @Override
    public void setBeanName(String s) {
        System.out.println("执行了通知");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("执行了 @PostConstruct");
    }

    public void init(){
        System.out.println("执行了 init-method 方法");
    }
    @PreDestroy
    public void preDestroy (){
        System.out.println("执行销毁方法");
    }
}
