package stream.com.xh.service;

import com.xh.config.OrderStreamsIN;
import com.xh.config.OrderStreamsOUT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import com.xh.pojo.Order;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/5 9:41
 * @description
 */
@Service
@Slf4j
public class OrderSenderService {

    private OrderStreamsOUT out;

    public OrderSenderService(OrderStreamsOUT out) {
        this.out = out;
    }

    public void sendOrder(Order order) {
        boolean send = out.output().send(MessageBuilder
                .withPayload(order)
                .setHeader("name", "order").build());
        if (send) {
            log.info("send order:{}", order);
        }
    }


}
