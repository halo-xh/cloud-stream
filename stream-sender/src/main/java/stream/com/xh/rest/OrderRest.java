package stream.com.xh.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xh.pojo.Order;
import stream.com.xh.service.OrderSenderService;
import stream.com.xh.topics.TopicSender1;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/5 9:47
 * @description
 */
@RestController
public class OrderRest {

    @Autowired
    OrderSenderService orderSenderService;

    @Autowired
    private TopicSender1 topicSender1;

    @Autowired
    private TopicSender1 topicSender2;

    @RequestMapping("/{id}")
    public String sendOrder(@PathVariable String id){
        Order order = Order.builder().date(new Date())
                .name("id-" + id)
                .price(BigDecimal.valueOf(123))
                .uuid(id)
                .build();
        Order order1 = Order.builder().date(new Date())
                .name("id-" + id)
                .price(BigDecimal.valueOf(123123))
                .uuid(id)
                .build();

        topicSender1.sendOrder(order);
        topicSender2.sendOrder(order);
//        orderSenderService.sendOrder(order);
        orderSenderService.publishEvent(order1);

        return order.toString();
    }


}
