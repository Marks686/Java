package com.example.demo;

import lombok.Data;
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
    private String name;
    private int age;

}
