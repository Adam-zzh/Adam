package com.huamiao.gateway.client;

import com.huamiao.common.entity.ResponseVo;
import com.huamiao.gateway.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest //获取启动类，加载配置，寻找主配置启动类 （被 @SpringBootApplication 注解的）
@RunWith(SpringRunner.class) //让JUnit运行Spring的测试环境,获得Spring环境的上下文的支持
@AutoConfigureMockMvc
public class UserClientTest {

    @Autowired
    private UserClient userClient;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findByUserName() {
        ResponseVo<User> ret = userClient.findByUserName("菩提花");
        System.out.println(1);
    }
}