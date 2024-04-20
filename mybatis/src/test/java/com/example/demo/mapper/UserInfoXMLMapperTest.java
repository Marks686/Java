package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserInfoXMLMapperTest {

    @Autowired
    private UserInfoXMLMapper userInfoXMLMapper;
    @Test
    void selectAll() {
        List<UserInfo> userInfos = userInfoXMLMapper.selectAll();
        log.info(userInfos.toString());
    }
}