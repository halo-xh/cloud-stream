package com.xh.topics;

import com.xh.config.MyChannels;
import com.xh.config.OrderStreamsIN;
import com.xh.pojo.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/4/14 20:22
 * @description
 */
@Component
@Slf4j
public class TopicListeners {

    @StreamListener(MyChannels.CHANNELIN1)
    public void handleOrderMsg1(GenericMessage<Order> orderGenericMessage) {
        Order order = orderGenericMessage.getPayload();
        log.info("get order: order{}", order.toString());
    }

    @StreamListener(MyChannels.CHANNELIN2)
    public void handleOrderMsg2(GenericMessage<Order> orderGenericMessage) {
        Order order = orderGenericMessage.getPayload();
        log.info("get order: {}", order.toString());
    }
}
