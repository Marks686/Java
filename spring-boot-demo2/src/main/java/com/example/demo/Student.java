package com.example.demo;

import lombok.Data;
import lombok.NonNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-20
 * Time: 8:17
 */

@Component
@ConfigurationProperties("student")
@Data
public class Student {
    private int id;
    @NonNull
    private String name;
    private int age;

    public static void main(String[] args) {
        Student s2 = new Student("张三");
        s2.setId(1);
        System.out.println(s2);
    }

}
