package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-25
 * Time: 22:53
 */
@Data
public class Userinfo implements Serializable {
    private final long serializableId = 1L;

    private int id;
    private String username;
    private String password;
    private String photo; //  头像
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private int state;
}
