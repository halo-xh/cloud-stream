package com.xh.stream.rest;

import com.xh.pojo.Order;
import com.xh.stream.sender.MySender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private MySender sender;

    @RequestMapping("/order/{id}")
    public String sendOrder(@PathVariable String id){
        Order order = Order.builder().date(new Date())
                .name("id-" + id)
                .price(BigDecimal.valueOf(Long.parseLong(id)))
                .uuid(id)
                .build();
        sender.sendOrder(order);
        return order.toString();
    }


}
