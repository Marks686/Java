package com.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-10
 * Time: 17:51
 */
// author: 张三
@Data
public class User {
    private int id;
    private String name;
    private String password;
}
