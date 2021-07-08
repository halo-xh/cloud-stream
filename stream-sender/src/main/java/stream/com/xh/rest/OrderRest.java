package stream.com.xh.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.xh.pojo.Order;
import stream.com.xh.service.OrderSenderService;

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


    @RequestMapping("/res/{id}")
    public String sendOrder(@PathVariable String id) {
        for (int i = 0; i < 100; i++) {
            Order order = Order.builder().uuid(String.valueOf(i)).date(new Date()).name(String.valueOf(i)).price(BigDecimal.ONE).build();
            orderSenderService.sendOrder(order);
        }
        return id;
    }


}
