package com.rabbit;

import com.rabbit.service.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HelloApplicationTests {

    @Resource
    private Sender sender;

    @Test
    public void hello() throws Exception{
        sender.send();
    }
}
