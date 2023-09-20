package com.demo.component;

import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-09-20
 * Time: 18:37
 */
@Controller
public class aController {
    public String sayHi(){
        return "Hi,Controler.";
    }
}
