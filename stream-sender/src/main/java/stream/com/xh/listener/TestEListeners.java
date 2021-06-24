package stream.com.xh.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import stream.com.xh.entiy.TestEntity;
import stream.com.xh.event.TestEvent;

/**
 * author  Xiao Hong
 * date  2021/6/24 20:43
 * description
 */
@Component
public class TestEListeners {


    @Async
    @TransactionalEventListener
    public void listen1(TestEvent event) {
        System.out.println("listen1 Thread.currentThread().getName() = " + Thread.currentThread().getName() + " event = " + event);
    }

    @TransactionalEventListener(condition = "#event.biz == 'biz1-a'")
    public void listen2(TestEvent event) {
        System.out.println("listen2 Thread.currentThread().getName() = " + Thread.currentThread().getName() + " event = " + event);
    }

    @TransactionalEventListener(condition = "#event.biz == 'biz2'")
    public void listen3(TestEvent event) {
        System.out.println("listen3 Thread.currentThread().getName() = " + Thread.currentThread().getName() + " event = " + event);
    }

    @EventListener(condition = "#event.biz == 'biz2'")
    public void listen4(TestEvent event) {
        System.out.println("listen4 Thread.currentThread().getName() = " + Thread.currentThread().getName() + " event = " + event);
    }

    @Async
    @EventListener
    public void listen5(TestEvent event) {
        System.out.println("listen5 Thread.currentThread().getName() = " + Thread.currentThread().getName() + " event = " + event);
    }

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void listen6(TestEvent event) {
        System.out.println("listen6 Thread.currentThread().getName() = " + Thread.currentThread().getName() + " event = " + event);
    }
}
