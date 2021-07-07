package stream.com.xh.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageChannels {

    String CHANNELOUT = "channel-out";

    @Output(CHANNELOUT)
    MessageChannel channelout();

}
