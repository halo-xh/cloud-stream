package com.xh.stream;

import com.xh.stream.channels.ChannelOutConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Topic2channelApplication.class)
class Topic2channelApplicationTests {

    @Autowired
    ChannelOutConfig outConfig;

    @Test
    void contextLoads() {
        outConfig.output().send(new GenericMessage<>("msg..."));
    }

}
