package com.demo.component;

import com.demo.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-09-21
 * Time: 16:51
 */
@Component
public class StudentBeans2 {
    @Bean
    public Student student(){
        Student stu = new Student();
        stu.setId(1);
        stu.setName("李四");
        stu.setAge(18);
        return stu;
    }
}
