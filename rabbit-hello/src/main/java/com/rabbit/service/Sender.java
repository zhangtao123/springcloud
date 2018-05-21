package com.rabbit.service;

import com.rabbit.config.Constent;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class Sender {

    @Resource
    private AmqpTemplate rabbitTemplate;

    /*直接向指定的队列发送消息*/
    public void send(){
        String context = "hello "+new Date();
        System.out.println("Sender : "+context);
        /*向hello队列里添加信息，并发送*/
        this.rabbitTemplate.convertAndSend("hello",context);
    }



    /*向direct交换机中发送消息*/
    public void sendDirect1(){
        String context = "hello Direct1"+new Date();
        System.out.println("Sender : "+context);
        /*向Direct_Exchange交换机里添加信息,路由键为Direct_Exchange_Key1，并发送*/
        this.rabbitTemplate.convertAndSend(Constent.Direct_Exchange_Name,Constent.Direct_Exchange_Key1,context);
    }
    public void sendDirect2(){
        String context = "hello Direct2"+new Date();
        System.out.println("Sender : "+context);
        /*向Direct_Exchange交换机里添加信息，路由键为Direct_Exchange_Key2，并发送*/
        this.rabbitTemplate.convertAndSend(Constent.Direct_Exchange_Name,Constent.Direct_Exchange_Key2,context);
    }



    /*向fanout交换机中发送消息*/
    public void sendFanout(){
        String context = "hello Fanout"+new Date();
        System.out.println("Sender : "+context);
        /*向hello队列里添加信息，并发送*/
        this.rabbitTemplate.convertAndSend(Constent.Fanout_Exchange_Name,"",context);
    }
}
