package com.bite.book.service;

import com.bite.book.dao.BookDao;
import com.bite.book.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;


    public List<BookInfo> getBookList(){
        //1.获取图书数据  mock表示虚拟的假数据
        List<BookInfo> bookInfos = bookDao.mockData();
        for (BookInfo bookInfo : bookInfos){
            if (bookInfo.getStatus() == 1){
                bookInfo.setStatusCN("可借阅");
            }else {
                bookInfo.setStatusCN("不可借阅");
            }
        }
        return bookInfos;
    }
}
