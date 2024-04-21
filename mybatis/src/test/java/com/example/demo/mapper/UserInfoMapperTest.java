package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@Slf4j
@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

//    @BeforeEach
//    void setUp() {
//        log.info("setUp");
//    }
//
//    @AfterEach
//    void tearDown() {
//        log.info("After");
//    }

    @Test
    void selectAll() {
        List<UserInfo> list = userInfoMapper.selectAll();
        log.info(list.toString());
    }

    @Test
    void selectAll2() {
        List<UserInfo> list = userInfoMapper.selectAll2();
        log.info(list.toString());
    }

    @Test
    void selectAll3() {
        List<UserInfo> list = userInfoMapper.selectAll3();
        log.info(list.toString());
    }

    @Test
    void selectOne() {
        log.info(userInfoMapper.selectOne(1).toString());
    }

    @Test
    void selectOne2() {
        log.info(userInfoMapper.selectOne(1).toString());
    }

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhaoliu");
        userInfo.setPassword("zhaoliu");
        userInfo.setAge(6);
        userInfo.setGender(0);
        userInfo.setPhone("123456789");

        Integer result = userInfoMapper.insert(userInfo);
        log.info("insert 方法，执行结果：{}",result);
    }

    @Test
    void delete() {
        userInfoMapper.delete(5);
    }

    @Test
    void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(16);
        userInfo.setId(4);
        Integer result = userInfoMapper.update(userInfo);
        if (result > 0){
            log.info("数据修改成功");
        }
    }


    @Test
    void selectByName() {
        log.info(userInfoMapper.selectByName("' or 1='1").toString());
    }

    @Test
    void selectUserSort() {
        log.info(userInfoMapper.selectUserSort("asc").toString());
    }

    @Test
    void selectUserByLike() {
        log.info(userInfoMapper.selectUserByLike("java").toString());
    }
}