package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class HelloController {

    @Value("${from}")
    private String from;

    @RequestMapping(value = "/from")
    public String from(){
        return this.from;
    }

    @RequestMapping("/from1")
    public String from1(){
        return this.from;
    }

}
