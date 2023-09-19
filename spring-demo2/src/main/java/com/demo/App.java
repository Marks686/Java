package com.demo;

import com.demo.component.ArticleController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-09-13
 * Time: 22:29
 */
public class App {
    public static void main(String[] args) {
        //1.得到Spring的上下文 创建的时候需要配置Spring 配置信息
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");
        System.out.println("ApplicationContext 之后的代码");
        //2.从Spring中取出Bean对象
        //component.User user = (component.User) context.getBean("user");//根据bean 名称来得到Bean对象
        //component.User user = contex .getBean(component.User.class);// 根据bean类型获取 Bean
//        User user = context.getBean("user", User.class);// 根据 Bean 名称 + 类型 获取Bean对象
//        //3.使用Bean(可选)
//        System.out.println(user.sayHi());
        ArticleController articleController = context.getBean("articleController", ArticleController.class);
        System.out.println(articleController.sayHello());
    }
}
