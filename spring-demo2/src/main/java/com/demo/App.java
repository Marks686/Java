package com.demo;

import com.demo.component.BController;
import com.demo.component.UserComponent;
import com.demo.controller.StudentController;
import com.demo.model.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

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
//        BeanFactory context = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));
        System.out.println("得到Spring之后");
        //2.从Spring中取出Bean对象
        //component.User user = (component.User) context.getBean("user");//根据bean 名称来得到Bean对象
        //component.User user = contex .getBean(component.User.class);// 根据bean类型获取 Bean
//        User user = context.getBean("user", User.class);// 根据 Bean 名称 + 类型 获取Bean对象
//        //3.使用Bean(可选)
//        System.out.println(user.sayHi());
//        ArticleController articleController = context.getBean("articleController", ArticleController.class);
//        System.out.println(articleController.sayHello());
//        aController controller  = context.getBean("aController",
//                aController.class);
//        System.out.println(controller.sayHi());
//        BController controller  = context.getBean("BController",
//                BController.class);
//        System.out.println(controller.sayHi());
//        String s1 = "UserInfo";
//        System.out.println("s1: " + Introspector.decapitalize(s1));
//
//        String s2 = "userInfo";
//        System.out.println("s2: " + Introspector.decapitalize(s2));
//
//        String s3 = "UInfo";
//        System.out.println("s3: " + Introspector.decapitalize(s3));
//        UserComponent component = context.getBean("userComponent", UserComponent.class);
//        System.out.println(component.sayHi());

//        User user = context.getBean("user", User.class);
//        System.out.println(user.sayHi());

//        Student student = context.getBean("student", Student.class);
//        System.out.println(student);
        StudentController sc = context.getBean("studentController", StudentController.class);
        sc.sayHi();
    }
}
