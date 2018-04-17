package com.exmaple.controller;

import com.didispace.dto.User;
import com.didispace.service.HelloService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorHelloController implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello "+name;
    }

    @Override
    public User hello(String name, Integer age) {
        return new User(name,age);
    }

    @Override
    public String hello(User user) {
        return "Hello "+user.getName() + ","+user.getAge();
    }
}
