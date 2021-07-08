package stream.com.xh.service;

import com.xh.pojo.Order;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/6/24 16:42
 * @description
 */
@Component
public class TestListener {

    @TransactionalEventListener(condition = "order.name = '123'")
    public void listened(Order order) {
        System.out.println("123TransactionalEventListener Thread.currentThread().getName() = " + Thread.currentThread().getName() + ": " + order.toString());
    }

    @TransactionalEventListener(condition = "order.name = '456'")
    public void listened0(Order order) {
        System.out.println("456TransactionalEventListener Thread.currentThread().getName() = " + Thread.currentThread().getName() + ": " + order.toString());
    }

    @TransactionalEventListener()
    public void listened2(Order order) {
        System.out.println("TransactionalEventListener Thread.currentThread().getName() = " + Thread.currentThread().getName() + ": " + order.toString());
    }

    @EventListener(condition = "order.name = '123'")
    public void listened3(Order order) {
        System.out.println("123TransactionalEventListener Thread.currentThread().getName() = " + Thread.currentThread().getName() + ": " + order.toString());
    }

    @EventListener(condition = "order.name = '456'")
    public void listened4(Order order) {
        System.out.println("456TransactionalEventListener Thread.currentThread().getName() = " + Thread.currentThread().getName() + ": " + order.toString());
    }



}
