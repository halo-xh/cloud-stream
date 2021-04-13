package com.xh.listener;

import com.xh.config.OrderStreamsIN;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;
import com.xh.pojo.Order;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/5 9:53
 */
@Component
@Slf4j
public class OrderListener {

    @StreamListener(OrderStreamsIN.INPUT)
    public void handleOrderMsg(@Payload Order order) {
        log.info("handleOrderMsg get order: {}", order.toString());
    }

    @StreamListener(OrderStreamsIN.INPUT)
    public void handleOrderMsg2(GenericMessage<Order> orderGenericMessage) {
        Order order = orderGenericMessage.getPayload();
        log.info("get order: {}", order.toString());
    }

    @StreamListener(value = OrderStreamsIN.INPUT,condition = "headers['name'] == 'test1'")
    public void handleNamedOrderMsg(@Payload Order order) {
        log.info("handleNamedOrderMsg get order: {}", order.toString());
    }

    //@StreamListener(value = Sink.INPUT)
    public void handleInputOrderMsg(@Payload Order order) {
        log.info("handleInputOrderMsg get order: {}", order.toString());
    }


}
