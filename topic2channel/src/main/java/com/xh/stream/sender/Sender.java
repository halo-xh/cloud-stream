package com.xh.stream.sender;

import com.xh.pojo.Order;
import com.xh.stream.channels.ChannelOutConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

/**
 * author  Xiao Hong
 * date  2021/5/18 21:22
 * description
 */
@Component
public class Sender {

    @Autowired
    private ChannelOutConfig channel;

    public void sendOrder(Order order) {
        channel.output().send(new GenericMessage<>(order));
    }
}
