package com.stream.service;

import com.stream.StreamApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;


/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 2018/4/26
 * Time: 15:43
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@EnableBinding(Sink.class)
public class SinkReceiver {
    private final static Logger LOGGER = LoggerFactory.getLogger(StreamApplication.class);

    @StreamListener(Sink.INPUT)
    public void receiver(Object payload){
        LOGGER.info("Received: "+payload);
    }
}