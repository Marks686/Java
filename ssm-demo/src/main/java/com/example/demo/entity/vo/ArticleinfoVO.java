package com.example.demo.entity.vo;

import com.example.demo.entity.Articleinfo;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-11-01
 * Time: 14:49
 */
@Data
public class ArticleinfoVO extends Articleinfo implements Serializable {
    private final long serializableId = 1L;
    private String username;

    @Override
    public String toString() {
        return "ArticleinfoVO{" +
                "username='" + username + '\'' +
                "} " + super.toString();
    }
}
