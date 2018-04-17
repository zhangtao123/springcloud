package com.example.service;

import com.example.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String hello() {
        return "error1";
    }

    @Override
    public String hello(@RequestParam("name") String name) {
        return "error2";
    }

    @Override
    public User hello(@RequestHeader("name") String name,@RequestHeader("name") Integer age) {
        return new User("未知",0);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "error3";
    }
}
