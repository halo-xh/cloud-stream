package stream.com.xh.config;

import com.xh.config.OrderStreamsOUT;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/5 9:38
 * @description
 */
@EnableBinding(OrderStreamsOUT.class)
public class StreamConfig {
}
