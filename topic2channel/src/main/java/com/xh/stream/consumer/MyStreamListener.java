package com.xh.stream.consumer;

import com.xh.pojo.Order;
import com.xh.stream.channels.ChannelInConfig;
import lombok.extern.slf4j.Slf4j;
//import com.xh.stream.channels.ChannelInConfig;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * author  Xiao Hong
 * date  2021/5/18 21:17
 * description
 */

@Slf4j
@Component
public class MyStreamListener {

    @StreamListener(ChannelInConfig.INPUT)
    public void listener(@Payload String order){
        log.info("receive msg by StreamListener : {}",order);
    }
}
