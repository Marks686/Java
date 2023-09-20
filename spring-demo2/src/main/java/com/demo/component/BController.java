package com.demo.component;

import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-09-20
 * Time: 21:32
 */
@Controller
public class BController {
    public String sayHi(){
        return "Hi,Controler.";
    }
}
