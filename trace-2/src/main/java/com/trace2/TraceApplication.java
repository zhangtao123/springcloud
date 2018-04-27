package com.trace2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 2018/4/27
 * Time: 17:26
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class TraceApplication {
    private final Logger logger = LoggerFactory.getLogger(TraceApplication.class);

    @RequestMapping(value = "/trace-2",method = RequestMethod.GET)
    public String trace(){
        logger.info("===<call trace-2>===");
        return "Trace";
    }

    public static void main(String[] args) {
        SpringApplication.run(TraceApplication.class,args);
    }
}