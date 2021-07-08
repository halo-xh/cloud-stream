import com.xh.pojo.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import stream.StreamSenderApplication;
import stream.com.xh.service.OrderSenderService;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * author  Xiao Hong
 * date  2021/6/30 22:43
 * description
 */
@SpringBootTest(classes = StreamSenderApplication.class)
public class MsgSender {

    @Resource
    private OrderSenderService senderService;

    @Test
    void sender100() {
        for (int i = 0; i < 100; i++) {
            Order order = Order.builder().uuid(String.valueOf(i)).date(new Date()).name(String.valueOf(i)).price(BigDecimal.ONE).build();
            senderService.sendOrder(order);
        }

    }
}
