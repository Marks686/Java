package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserInfo2MapperTest {
    @Autowired
    private UserInfo2Mapper userInfo2Mapper;

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("libai-2024-1");
        userInfo.setPassword("liibaiiili");
        userInfo.setAge(14);
//        userInfo.setGender(1);
        userInfo.setPhone("10290192");
        userInfo2Mapper.insert(userInfo);
    }

    @Test
    void insertByXML() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("libai-2024-3");
        userInfo.setPassword("liibaiiili");
        userInfo.setAge(18);
//        userInfo.setGender(1);
//        userInfo.setPhone("10290192");
        userInfo2Mapper.insertByXML(userInfo);
    }

    @Test
    void selectByCondition() {
        UserInfo userInfo = new UserInfo();
//        userInfo.setUsername("libai");
//        userInfo.setGender(0);
//        userInfo.setAge(14);
        userInfo2Mapper.selectByCondition(userInfo);
        log.info(userInfo.toString());
    }

    @Test
    void selectByCondition3() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("libai");
//        userInfo.setGender(0);
//        userInfo.setAge(14);
        userInfo2Mapper.selectByCondition3(userInfo);
        log.info(userInfo.toString());
    }
}