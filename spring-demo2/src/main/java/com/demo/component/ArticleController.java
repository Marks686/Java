package com.demo.component;

import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-09-19
 * Time: 21:55
 */
@Controller
public class ArticleController {
    public String sayHello(){
        return "Hello,Controler.";
    }
}
