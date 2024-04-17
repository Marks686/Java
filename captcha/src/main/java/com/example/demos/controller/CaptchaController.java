package com.example.demos.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RequestMapping("/admin")
@RestController
public class CaptchaController {
    private static final String KAPTCHA_SESSION_KEY="HOME_KAPTCHA_SESSION_KEY";
    private static final String KAPTCHA_SESSION_DATE = "HOME_KAPTCHA_SESSION_DATE";
    private static final Long SESSION_TIMEOUT = 60*1000L;
    //验证成功：true
    //验证失败：false
    @RequestMapping("/check")
    public Boolean check(String captcha, HttpSession session){
        if (!StringUtils.hasLength(captcha)){
            return false;
        }
        //从session中获取验证码
        String savaCaptcha = (String) session.getAttribute(KAPTCHA_SESSION_KEY);
        Date savaData = (Date) session.getAttribute(KAPTCHA_SESSION_DATE);
        //比对验证码
        if (captcha.equals(savaCaptcha)){
            //比对日期
            if (savaData==null || System.currentTimeMillis()-savaData.getTime() < SESSION_TIMEOUT)
            return true;
        }
        return false;
    }
}
