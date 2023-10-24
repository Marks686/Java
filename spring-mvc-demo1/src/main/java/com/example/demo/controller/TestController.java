package com.example.demo.controller;

import com.example.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.CookieStore;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-21
 * Time: 20:50
 */
@RequestMapping("/test")
//@ResponseBody      // 告诉我要返回的body数据 不是页面
//@Controller        // 让框架启动的时候加载当前类
//@Component     // 张冠李戴 尽量不这样去写
@RestController  // @Controller + @ResponseBody
@Slf4j
public class TestController {

//    @RequestMapping("/hi")
//    @RequestMapping(value = "/hi",method = RequestMethod.POST)
//    @PostMapping("/hi") // 当前接口只支持 POST
    @GetMapping("/hi")
    public String sayHi(String name,Integer v){
        return "Hi," + name + " |   V:" + v;
    }

    @GetMapping("/num")
    public String getNum(Integer num){
        return "num= " + num;
    }


    @GetMapping("/show-user")
    public String showUser(User user){
        return user.toString();
    }

    // 接收 JSON 对象 (和第三方系统通讯是常见的场景)
    @PostMapping("show-json-user")
    public String showJSONUser(@RequestBody User user){
        return user.toString();
    }


    @GetMapping("/show-time")
//    public String showTime(String t,String t2){
    public String showTime(@RequestParam(value = "t",required = false) String startTime,
                           @RequestParam("t2") String endTime){
        return "开始时间： " + startTime + "    |  结束时间： " + endTime;
    }

    @RequestMapping("/login/{username}/{password}")
    public String login(@PathVariable("username") String username,
                        @PathVariable("password") String password){
        return username + ":" + password;
    }
    @RequestMapping("/show/{username}/and/{password}")
    public String showInfo(@PathVariable("password") String pwd,
                           @PathVariable("username") String username){
        return username + ":" + pwd;
    }


    @RequestMapping("/upfile")
    public String upfile(@RequestPart("myfile")MultipartFile file) throws IOException {
        String path = "D:\\tmp\\img.jpg";
        // 保存文件
        file.transferTo(new File(path));
        return path;
    }


    @RequestMapping("/myupfile")
    public String myUpFile(@RequestPart("myfile") MultipartFile file) throws IOException {
        // 根目录
        String path = "D:\\tmp\\";
        // 根目录 + [唯一的文件名]
        path += UUID.randomUUID().toString().replace("-","");
        // 根目录 + 唯一的文件名 + [文件的后缀]  ex: .jpg
        path += file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        file.transferTo(new File(path));
        return path;
    }

    // Spring MVC 内置了HttpServletRequest 和 HttpServletResponse
    @GetMapping("/getparam")
    public String getParam(HttpServletRequest req){
        return req.getParameter("username");
    }

    @RequestMapping("/getck")
    public String getCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();    // servlet 获取其全部 cookie
        for (Cookie item : cookies){
            log.error(item.getName() + ":" + item.getValue());
        }
        return "get cookie.";
    }

    @RequestMapping("/getck2")
    public String getCookie2(@CookieValue("zhangsan")String val){
        return "Cookie Value:" + val;
    }


    // 获取 Hander 信息
    @RequestMapping("/getua")
    public String getUa(@RequestHeader("User-Agent") String userAgent){
        return userAgent;
    }


    // 设置 Session
    @RequestMapping("/setsess")
    public String setSession(HttpServletRequest request){
        HttpSession session =  request.getSession();
        session.setAttribute("userinfo","userinfo");
        return "Set Session Success";
    }

    // 读取 Session
    @RequestMapping("/getsess")
    public String getSession(HttpServletRequest request){
        HttpSession session = request.getSession(false);  // 一定要加false
        if(session != null && session.getAttribute("userinfo") != null){
            return (String) session.getAttribute("userinfo");
        } else {
            return "暂无 Session 信息";
        }
    }


    // 读取 Session 方式二
    @RequestMapping("/getsess2")
    public String getSession2(@SessionAttribute(value = "userinfo",required = false) String userinfo){
        return userinfo;
    }
    @RequestMapping("/respjson")
    public HashMap<String,String> respJson(){
        HashMap<String,String> map = new HashMap<>();
        map.put("Java","Java Value");
        map.put("MySQL","MySQL Value");
        map.put("Redis","Redis Value");
        return map;
    }

}
