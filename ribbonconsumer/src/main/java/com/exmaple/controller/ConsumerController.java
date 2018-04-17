package com.exmaple.controller;

import com.exmaple.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConsumerController {
    @Resource
    HelloService helloService;

    @RequestMapping(value = "ribbon-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
        return helloService.helloService();
    }
}
