package com.exmaple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HellpApplication {
    public static void main(String[] args) {
        SpringApplication.run(HellpApplication.class,args);
    }
}
