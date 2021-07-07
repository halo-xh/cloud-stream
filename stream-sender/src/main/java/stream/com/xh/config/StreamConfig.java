package stream.com.xh.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/5 9:38
 * @description
 */
@EnableBinding({MessageChannels.class, Processor.class})
public class StreamConfig {
}
