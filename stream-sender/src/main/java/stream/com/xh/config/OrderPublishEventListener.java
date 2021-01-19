package stream.com.xh.config;

import com.xh.config.OrderStreamsOUT;
import com.xh.pojo.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.EventListener;
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
@Component
@Slf4j
public class OrderPublishEventListener {

    @Autowired
    private OrderStreamsOUT out;

    @EventListener
    public void publishUserChangeEvent(PayloadApplicationEvent<Order> eventRequest) {
        log.info("Kafka stream send user change event, request:{}", eventRequest.getPayload());
        Map<String, Object> headers = new HashMap<>();
        headers.put("order-event", eventRequest.getPayload().getName());
        System.out.println("publishUserChangeEvent  Thread.currentThread().getId() = " + Thread.currentThread().getId());
        boolean result = out.output().send(new GenericMessage<>(eventRequest.getPayload(), headers));
        log.info("Kafka stream send user change event result:{}", result);
    }
}
