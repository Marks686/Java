package com.example.demo.entity;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-11-12
 * Time: 18:36
 */
@Data
public class UserInfo {
    private Integer id;
    private String username;
    private String password;
    private String photo;
    private String createtime;
    private String updatetime;
    private Integer state;
}
