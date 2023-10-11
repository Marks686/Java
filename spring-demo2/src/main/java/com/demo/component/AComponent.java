package com.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-11
 * Time: 18:20
 */
@Component
public class AComponent {

    @Autowired
    private BComponent bComponent;

    @PostConstruct
    public void postConstruct(){
        bComponent.sayHi();
        System.out.println("执行了 A 对象的 PostConstruct 方法");
    }
}
