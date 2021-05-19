package com.xh.ttl.config;

import com.xh.ttl.common.BytesUtils;
import com.xh.ttl.common.TimerMsgTopic;
import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.Headers;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.xh.ttl.kafka.producer.TimedSender.TTL_HEADER;

/**
 * author  Xiao Hong
 * date  2021/5/19 20:49
 * description
 */
@Component
public class TimerInterceptor implements ConsumerInterceptor<String, String> {

    @Override
    public ConsumerRecords<String, String> onConsume(ConsumerRecords records) {
        long now = System.currentTimeMillis();
        // 存放没过期的消息
        Map<TopicPartition, List<ConsumerRecord<String, String>>> passedRecords = new HashMap<>();
        Set<TopicPartition> partitions = records.partitions();
        for (TopicPartition partition : partitions) {
            Iterable<ConsumerRecord<String, String>> timerRecords = records.records(partition);
            List<ConsumerRecord<String, String>> consumerRecordsList = new ArrayList<>();
            timerRecords.forEach(record -> {
                Headers headers = record.headers();
                long ttlVal = -1L;
                for (Header header : headers) {
                    if (header.key().equals(TTL_HEADER)) {
                        ttlVal = BytesUtils.bytesToLong(header.value());
                    }
                }
                /*
                 * record.timestamp() :  a timestamp as marked by the corresponding ProducerRecord. ProducerRecord标记的时间。
                 * {@link org.apache.kafka.clients.consumer.ConsumerRecord}
                 */
                boolean notOutOfTime =  (record.timestamp() + ttlVal * 1000L > now);
                if (notOutOfTime) {
                    consumerRecordsList.add(record);
                }
            });
            if (!consumerRecordsList.isEmpty()) {
                passedRecords.put(partition, consumerRecordsList);
            }
        }
        return new ConsumerRecords<>(passedRecords);
    }

    @Override
    public void close() {

    }

    @Override
    public void onCommit(Map offsets) {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
