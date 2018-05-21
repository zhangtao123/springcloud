package com.rabbit.controller;

import com.rabbit.service.Sender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 2018/5/21
 * Time: 14:17
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitTest {

    @Resource
    private Sender sender;


    @PostMapping("/hello")
    public void hello() {
        sender.sendFanout();
    }

    @PostMapping("/oneToMany")
    public void oneToMany() {
        for(int i=0;i<10;i++){
            sender.sendFanout();
        }
    }

    @RequestMapping("/testDirect")
    public void testDirect() {
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i%2==0) {
                sender.sendDirect1();
            }else{
                sender.sendDirect2();
            }
        }
    }


    @PostMapping("/test")
    public String test() {
        return "success";
    }

}