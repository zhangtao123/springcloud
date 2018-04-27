package com.trace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 2018/4/27
 * Time: 17:16
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class TraceApplication {
    private final Logger logger = LoggerFactory.getLogger(TraceApplication.class);

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @RequestMapping(value = "/trace-1",method = RequestMethod.GET)
    public String trace(){
        logger.info("===call trace-1===");
        return restTemplate().getForEntity("http://trace-2/trace-2",String.class).getBody();
    }


    public static void main(String[] args) {
        SpringApplication.run(TraceApplication.class,args);
    }
}