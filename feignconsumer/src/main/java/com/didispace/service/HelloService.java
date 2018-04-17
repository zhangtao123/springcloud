package com.didispace.service;

import com.didispace.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/*服务消费者名称*/
@FeignClient(value = "HELLO-SERVICE")
public interface HelloService {

    @RequestMapping("/users")
    String hello();

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);


    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);


    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
    String hello(@RequestBody User user);

}
