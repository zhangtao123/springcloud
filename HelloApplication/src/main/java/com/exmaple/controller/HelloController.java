package com.exmaple.controller;

import com.exmaple.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Random;
@RefreshScope
@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Resource
    private EurekaRegistration eurekaRegistration;

    @Value("${from}")
    private String from;

    @RequestMapping("/from")
    public String from(){
        return this.from;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() throws Exception {
        long start = System.currentTimeMillis();
        int sleepTime = new Random().nextInt(3000);
        LOGGER.info("sleepTime:"+sleepTime);
        Thread.sleep(sleepTime);
        LOGGER.info("/hello,host:" + eurekaRegistration.getHost() + ",service_id:" + eurekaRegistration.getServiceId() + ",uri:" + eurekaRegistration.getUri());
        long end = System.currentTimeMillis();
        LOGGER.info("Spand time :"+(end - start));
        return "Hello World";
    }



    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(){
        LOGGER.info("/hello,host:" + eurekaRegistration.getHost() + ",service_id:" + eurekaRegistration.getServiceId() + ",uri:" + eurekaRegistration.getUri());
        return "Hello user";
    }

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello(@RequestParam("name") String name){
        return "Hello "+name;
    }

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age){
        return new User(name,age);
    }

    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
    public String hello(@RequestBody User user){
        return "Hello "+user.getName() +", "+user.getAge();
    }

}
