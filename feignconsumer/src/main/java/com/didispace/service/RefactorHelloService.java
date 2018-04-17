package com.didispace.service;

import com.didispace.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "HELLO-SERVICE")
public interface RefactorHelloService extends com.didispace.service.HelloService {
    @Override
    String hello();

    @Override
    String hello(String name);

    @Override
    User hello(String name, Integer age);

    @Override
    String hello(User user);
}
