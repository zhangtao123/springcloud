package com.exmaple.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Resource
    private EurekaRegistration eurekaRegistration;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        LOGGER.info("/hello,host:" + eurekaRegistration.getHost() + ",service_id:" + eurekaRegistration.getServiceId() + ",uri:" + eurekaRegistration.getUri());
        return "Hello World";
    }
}
