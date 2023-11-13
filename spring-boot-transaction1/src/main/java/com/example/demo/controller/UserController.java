package com.example.demo.controller;

import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-11-12
 * Time: 18:35
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private DataSourceTransactionManager transactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;

    @RequestMapping("/add")
    public int add(UserInfo userInfo){
        // 非空效验
        if (userInfo == null || !StringUtils.hasLength(userInfo.getUsername())
        || !StringUtils.hasLength(userInfo.getPassword())){
            return 0;
        }
        // 1. 开始事务
        TransactionStatus transactionStatus =
                transactionManager.getTransaction(transactionDefinition);
        // 手动设置创建时间和修改时间的默认值
        userInfo.setCreatetime(LocalDateTime.now().toString());
        userInfo.setUpdatetime(LocalDateTime.now().toString());


        int result = userService.add(userInfo);
        System.out.println("添加: " + result);

        // 2.回滚事务
        //transactionManager.rollback(transactionStatus);

        // 3.提交事务
        transactionManager.commit(transactionStatus);

        return result;
    }
    @Transactional  //声明式事务(自动提交)
    @RequestMapping("/insert")
    public Integer insert(UserInfo userInfo){
        // 非空效验
        if (userInfo == null || !StringUtils.hasLength(userInfo.getUsername())
        || !StringUtils.hasLength(userInfo.getPassword())){
            return 0;
        }
        int result = userService.add(userInfo);
        System.out.println("添加 insert: " + result);
        try {
            int num = 10 / 0;
        } catch (Exception e) {
//            // 1.将异常继续抛出
//            throw e;
            System.out.println(e.getMessage());
            // 2.使用代码手动回顾事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }
}
