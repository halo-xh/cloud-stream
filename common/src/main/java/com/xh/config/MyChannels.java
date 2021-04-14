package com.xh.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/4/14 19:53
 * @description
 */
public interface MyChannels {

    String CHANNELIN1 = "channelin1";
    String CHANNELIN2 = "channelin2";

    @Input(CHANNELIN1)
    SubscribableChannel channelin1();

    @Input(CHANNELIN2)
    SubscribableChannel channelin2();

    String CHANNELOUT1 = "channelout1";
    String CHANNELOUT2 = "channelout2";

    @Output(CHANNELOUT1)
    SubscribableChannel channelout1();

    @Output(CHANNELOUT2)
    SubscribableChannel channelout2();
}
