package com.example.demo.entity.vo;

import com.example.demo.entity.Userinfo;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-11-18
 * Time: 21:00
 */
@Data
public class UserinfoVO extends Userinfo {
    private Integer artCount; // 此人发表的文章总数
}
