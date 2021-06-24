package stream.com.xh.topics;

import com.xh.config.MyChannels;
import com.xh.pojo.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import stream.com.xh.config.MessageChannels;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/4/14 19:55
 * @description
 */
@Slf4j
@Component
public class TopicSender1 {

    @Autowired
    private MessageChannels myChannels;

    public void sendOrder(Order order) {
        boolean send = myChannels.channelout1().send(MessageBuilder
                .withPayload(order)
                .setHeader("name", "test1").build());
        if (send) {
            log.info("send order:{}", order);
        }
    }


}
