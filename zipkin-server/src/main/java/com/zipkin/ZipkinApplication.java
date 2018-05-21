package com.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 2018/4/27
 * Time: 17:05
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@EnableZipkinStreamServer
@SpringBootApplication
public class ZipkinApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class,args);
    }
}