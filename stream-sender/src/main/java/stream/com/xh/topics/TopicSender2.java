package stream.com.xh.topics;

import com.xh.config.MyChannels;
import com.xh.pojo.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/4/14 19:55
 * @description
 */
@Slf4j
@Component
public class TopicSender2 {

    @Autowired
    private MyChannels myChannels;


    public void sendOrder2(Order order) {
        boolean send = myChannels.channelout2().send(MessageBuilder
                .withPayload(order)
                .setHeader("name", "test1").build());
        if (send) {
            log.info("send order:{}", order);
        }
    }
}
