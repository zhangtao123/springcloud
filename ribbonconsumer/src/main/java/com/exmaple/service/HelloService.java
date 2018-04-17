package com.exmaple.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
@Service
public class HelloService {
    @Resource
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public  String helloService(){
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
    }

    public  String helloFallback(){
        return "error";
    }
}
