package com.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    /*创建一个队列，取名为：hello*/
    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }
}
