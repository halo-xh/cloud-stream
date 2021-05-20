package com.xh.stream.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * author  Xiao Hong
 * date  2021/5/18 21:20
 * description
 */
@Slf4j
//@Component
public class MyKafkaListener {

    @KafkaListener(topics = "channel-out",groupId = "group2")
    public void handleNamedOrderMsg(String record) {
        log.info(" KafkaListener - get order: {}", record);
    }
}
