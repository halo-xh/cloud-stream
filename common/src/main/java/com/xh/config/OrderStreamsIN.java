package com.xh.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/5 9:38
 * @description
 */
public interface OrderStreamsIN {

    String INPUT = "order-topic";

    @Input(INPUT)
    SubscribableChannel input();

}
