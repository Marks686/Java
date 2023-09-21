package com.demo.component;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-09-21
 * Time: 15:49
 */
@Component
public class UserComponent {
    public String sayHi(){
        return "Hi,@Component";
    }
}
