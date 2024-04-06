package com.bite.book;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequestMapping("/book")
@RestController
public class BookController {

    @RequestMapping("/getBookList")
    public List<BookInfo> getBookList(){
        //1.获取图书数据  mock表示虚拟的假数据
        List<BookInfo> bookInfos = mockData();
        for (BookInfo bookInfo : bookInfos){
            if (bookInfo.getStatus() == 1){
                bookInfo.setStatusCN("可借阅");
            }else {
                bookInfo.setStatusCN("不可借阅");
            }
        }
        //2.对图书数据进行修改
        //3.返回数据
        return bookInfos;
    }

    private List<BookInfo> mockData() {
        //对于已知的数据量 创建list的时候 建议指定初始化容量
        List<BookInfo> bookInfos = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(i);
            bookInfo.setBookName("图书"+i);
            bookInfo.setAuthor("作者"+i);
            bookInfo.setCount(new Random().nextInt(200));
            bookInfo.setPrice(new BigDecimal(new Random().nextInt(100)));
            bookInfo.setPublish("出版社"+i);
            bookInfo.setStatus(i%5==0?2:1);
            bookInfos.add(bookInfo);
        }
        return bookInfos;
    }
}
