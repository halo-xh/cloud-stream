package com.xh.ttl.kafka.comuser;

import com.xh.ttl.common.TimerMsgTopic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * author  Xiao Hong
 * date  2021/5/19 21:31
 * description
 */

@Component
@Slf4j
public class TimerListener {

    @KafkaListener(topics = TimerMsgTopic.topic,groupId = "g1",containerFactory = "batchContainerFactory")
    public void handleNamedOrderMsg(String record) {
        log.info(" KafkaListener -  get order: {}", record);
    }
}
