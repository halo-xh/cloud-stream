package stream.com.xh.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageChannels {

    String CHANNELOUT1 = "output";

    String CHANNELOUT2 = "channel-out1";

    String CHANNELOUT3 = "channel-out2";

    @Output(CHANNELOUT1)
    MessageChannel channelout1();

    @Output(CHANNELOUT2)
    MessageChannel channelout2();

    @Output(CHANNELOUT3)
    MessageChannel channelout3();
}
