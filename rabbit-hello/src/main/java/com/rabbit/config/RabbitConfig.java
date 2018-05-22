package com.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    /*创建队列，取名为：hello*/
    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }
    @Bean
    @Qualifier("queuesName1")
    public Queue createFanoutMessage1(){
        return new Queue(Constent.QUEUES_NAME1);
    }
    @Bean
    @Qualifier("queuesName2")
    public Queue createFanoutMessage2(){
        return new Queue(Constent.QUEUES_NAME2);
    }
    @Bean
    @Qualifier("queuesName3")
    public Queue createFanoutMessage3(){
        return new Queue(Constent.QUEUES_NAME3);
    }

    @Bean
    @Qualifier("queuesName4")
    public Queue createDirectMessage1(){
        return new Queue(Constent.QUEUES_NAME4);
    }
    @Bean
    @Qualifier("queuesName5")
    public Queue createDirectMessage2(){
        return new Queue(Constent.QUEUES_NAME5);
    }






    /*创建一个交换机*/
    @Bean
    @Qualifier("directName")
    public DirectExchange createDirectExchange(){
        return new DirectExchange(Constent.Direct_Exchange_Name);
    }
    @Bean
    @Qualifier("fanoutName")
    public  FanoutExchange createFanoutExchange(){
        return new FanoutExchange(Constent.Fanout_Exchange_Name);
    }





    /*绑定队列到交换机*/
    @Bean
    Binding bindingFanoutExchangeMessageA(@Qualifier("queuesName1") Queue queuesName1, @Qualifier("fanoutName") FanoutExchange  fanoutName) {
        return BindingBuilder.bind(queuesName1).to(fanoutName);
    }
    @Bean
    Binding bindingFanoutExchangeMessageB(@Qualifier("queuesName2") Queue queuesName2, @Qualifier("fanoutName") FanoutExchange  fanoutName) {
        return BindingBuilder.bind(queuesName2).to(fanoutName);
    }
    @Bean
    Binding bindingFanoutExchangeMessageC(@Qualifier("queuesName3") Queue queuesName3, @Qualifier("fanoutName") FanoutExchange  fanoutName) {
        return BindingBuilder.bind(queuesName3).to(fanoutName);
    }


    /*申明路由键的地方：(1)：队列绑定到交换器;(2)：向交换机发送消息*/
    @Bean
    Binding bindingDirectExchangeMessageB(@Qualifier("queuesName4") Queue queuesName4, @Qualifier("directName") DirectExchange  directName) {
        return BindingBuilder.bind(queuesName4).to(directName).with(Constent.Direct_Exchange_Key1);
    }
    @Bean
    Binding bindingDirectExchangeMessageC(@Qualifier("queuesName5") Queue queuesName5, @Qualifier("directName") DirectExchange  directName) {
        return BindingBuilder.bind(queuesName5).to(directName).with(Constent.Direct_Exchange_Key2);
    }




}
