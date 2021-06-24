package stream.com.xh.service;

import com.xh.config.OrderStreamsIN;
import com.xh.config.OrderStreamsOUT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import com.xh.pojo.Order;
import stream.com.xh.config.MessageChannels;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/5 9:41
 * @description
 */
@Service
@Slf4j
public class OrderSenderService {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private MessageChannels out;

    public void sendOrder(Order order) {
        boolean send = out.channelout3().send(MessageBuilder
                .withPayload(order)
                .setHeader("name", "test1").build());
        if (send) {
            log.info("send order:{}", order);
        }
    }

    public void publishEvent(Order order){
        System.out.println("publishEvent Thread.currentThread().getId() = " + Thread.currentThread().getId());
        applicationEventPublisher.publishEvent(order);
    }


}
