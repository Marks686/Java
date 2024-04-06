package com.bite.book.model;



import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookInfo {
    private Integer id;
    //书名
    private String bookName;

    //作者
    private String author;

    //数量
    private Integer count;

    //价格用BigDecimal
    private BigDecimal price;

    // 出版社
    private String publish;

    //状态 不存汉字
    private Integer status;//1-可借阅 2-不可借阅

    private String statusCN;




}
