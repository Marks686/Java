package com.bite.book.controller;

import com.bite.book.model.BookInfo;
import com.bite.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequestMapping("/book")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;


    @RequestMapping("/getBookList")
    public List<BookInfo> getBookList(){
        List<BookInfo> bookInfos = bookService.getBookList();
        return bookInfos;
    }
}
