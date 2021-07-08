package com.xh.stream.channels;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ChannelOutConfig {

    String OUTPUT = "channel_out";

    @Output(ChannelOutConfig.OUTPUT)
    MessageChannel output();
}
