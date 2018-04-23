package com.rabbit.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class Sender {

    @Resource
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context = "hello "+new Date();
        System.out.println("Sender : "+context);
        /*向hello队列里添加信息，并发送*/
        this.rabbitTemplate.convertAndSend("hello",context);
    }
}
