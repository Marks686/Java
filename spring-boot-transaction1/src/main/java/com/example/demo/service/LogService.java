package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-11-15
 * Time: 23:28
 */
@Service
public class LogService {
    @Transactional(propagation = Propagation.REQUIRED)
//    @Transactional
    public int add(){
        try {
            int num = 10/0;
        }
        catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return 1;
    }
}
