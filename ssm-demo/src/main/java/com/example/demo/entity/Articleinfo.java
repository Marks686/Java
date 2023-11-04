package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-11-01
 * Time: 14:47
 */
@Data
public class Articleinfo implements Serializable {
    private final long serializableId = 1L;

    private int id;
    private String title;
    private String content;
    private String createtime;
    private String updatetime;
    private int uid;
    private int rcount;
    private int state;
}
