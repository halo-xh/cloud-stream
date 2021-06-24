package stream.com.xh.config;

import com.xh.config.OrderStreamsOUT;
import com.xh.pojo.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/14 16:27
 * @description
 */
//@Component
@Slf4j
public class OrderPublishEventListener {

    @Autowired
    private MessageChannel out;


    /**
     * stream.com.xh.config.OrderPublishEventListener#publishUserChangeEvent(org.springframework.context.PayloadApplicationEvent)
     * stream.com.xh.service.OrderSenderService#publishEvent(com.xh.pojo.Order)
     *
     * 发布事件 和事件监听实则  默认是同一线程。
     */
    @EventListener
    public void publishUserChangeEvent(PayloadApplicationEvent<Order> eventRequest) {
        log.info("Kafka stream send user change event, request:{}", eventRequest.getPayload());
        Map<String, Object> headers = new HashMap<>();
        headers.put("order-event", eventRequest.getPayload().getName());
        System.out.println("publishUserChangeEvent  Thread.currentThread().getId() = " + Thread.currentThread().getId());
        boolean result = out.send(new GenericMessage<>(eventRequest.getPayload(), headers));
        log.info("Kafka stream send user change event result:{}", result);
    }

    /**
     * 配置，发布和监听多线程异步操作，
     */
    @Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
        SimpleApplicationEventMulticaster eventMulticaster
                = new SimpleApplicationEventMulticaster();

        eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return eventMulticaster;
    }
}
