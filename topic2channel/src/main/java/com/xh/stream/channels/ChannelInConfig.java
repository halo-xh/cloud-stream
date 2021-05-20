package com.xh.stream.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ChannelInConfig {

    String INPUT = "input-channel";

    @Input(ChannelInConfig.INPUT)
    SubscribableChannel input();
}
