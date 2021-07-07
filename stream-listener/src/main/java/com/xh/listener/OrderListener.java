package com.xh.listener;

import com.xh.config.OrderStreamsIN;
import com.xh.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;
import com.xh.pojo.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/5 9:53
 */
@Component
@Slf4j
public class OrderListener {


    @Autowired
    private OrderService orderService;

    /**
     * 测试 利用@Transactional 注解的 timeout 引发异常 从而 限制消息消费时间。
     * 结果： 不可用: TransactionException: transaction timeout expired 后进入死信。
     *     ！！！ 但是还是需要等方法执行完才会进行下一个消息的消费 ！！！
     *     脑残。 AOP的后置处理器，肯定是要等方法体执行完啊！ 本根不会因为超时而中断进行中的线程方法。
     *     研究Transactional timeout 实现方法。
     *
     * @param order order from kafka msg
     */
    @Transactional(timeout = 10)
    @StreamListener(Sink.INPUT)
    public void handleOrderMsg(@Payload Order order) {
        log.info("handleOrderMsg get order: {}", order.toString());
        try {
            orderService.save(order);
            Thread.sleep(15 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("handleOrderMsg handled order: {}", order.toString());
    }


//    @StreamListener(value = Sink.INPUT,condition = "headers['name'] == 'test1'")
//    public void handleNamedOrderMsg(@Payload Order order) {
//        log.info("handleNamedOrderMsg get order: {}", order.toString());
//    }

    //@StreamListener(value = Sink.INPUT)
    public void handleInputOrderMsg(@Payload Order order) {
        log.info("handleInputOrderMsg get order: {}", order.toString());
    }


}
