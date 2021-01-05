package com.xh.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/5 11:09
 * @description
 */
public interface OrderStreamsOUT {

    String OUTPUT = "order-topic";

    @Output(OUTPUT)
    MessageChannel output();


}
