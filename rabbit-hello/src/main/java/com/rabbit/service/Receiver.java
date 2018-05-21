package com.rabbit.service;

import com.rabbit.config.Constent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/****
 *
 *用于监听指定的队列，有消息进来，就执行相应的监听方法
 *
 * */

@Component
public class Receiver {

    @RabbitListener(queues = "hello")
    public void process(String hello) {
        System.out.println("Receiver : " + hello);
    }

    @RabbitListener(queues = Constent.QUEUES_NAME1)
    public void processA(String str1) {
        System.out.println("ReceiveA:" + str1);
    }

    @RabbitListener(queues = Constent.QUEUES_NAME2)
    public void processB(String str) {
        System.out.println("ReceiveB:" + str);
    }

    @RabbitListener(queues = Constent.QUEUES_NAME3)
    public void processC(String str) {
        System.out.println("ReceiveC:" + str);
    }

    @RabbitListener(queues = Constent.QUEUES_NAME4)
    public void processD(String str) {
        System.out.println("Receive========> B :" + str);
    }

    @RabbitListener(queues = Constent.QUEUES_NAME5)
    public void processE(String str) {
        System.out.println("Receive========> C :" + str);
    }
}
