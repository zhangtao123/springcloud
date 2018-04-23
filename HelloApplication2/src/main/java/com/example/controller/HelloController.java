package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RefreshScope
@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Value("${from}")
    private String from;

    @Resource
    private EurekaRegistration eurekaRegistration;

    @RequestMapping(value = "/from")
    public String from(){
        return this.from;
    }

    @RequestMapping("/from1")
    public String from1(){
        return this.from;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String users(){
        LOGGER.info("/hello,host:" + eurekaRegistration.getHost() + ",service_id:" + eurekaRegistration.getServiceId() + ",uri:" + eurekaRegistration.getUri());
        return "Hello user";
    }

}
