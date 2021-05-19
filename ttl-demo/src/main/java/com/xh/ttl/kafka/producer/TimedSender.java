package com.xh.ttl.kafka.producer;

import com.xh.pojo.Order;
import com.xh.ttl.common.BytesUtils;
import com.xh.ttl.common.TimerMsgTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.apache.kafka.common.header.internals.RecordHeaders;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * author  Xiao Hong
 * date  2021/5/19 20:24
 * description
 */
@Component
public class TimedSender {

    public static final String TTL_HEADER = "ttl";

    public RecordMetadata sender(Order order) throws ExecutionException, InterruptedException {
        KafkaProducer<String, String> producer = getProducer();
        RecordHeader recordHeader = new RecordHeader(TTL_HEADER, BytesUtils.longToByte(30L));
        ProducerRecord<String, String> record = new ProducerRecord<>(
                TimerMsgTopic.topic,
                0,
                System.currentTimeMillis(),
                "fakeKey",
                "30s - msg",
                new RecordHeaders().add(recordHeader));

        ProducerRecord<String, String> record2 = new ProducerRecord<>(
                TimerMsgTopic.topic,
                0,
                System.currentTimeMillis() - 35 * 1000L,// 过期消息。将不会被消费到
                "fakeKey",
                "30s - msg - out of time.",
                new RecordHeaders().add(recordHeader));
        producer.send(record2).get();
        return producer.send(record).get();
    }

    private KafkaProducer<String, String> getProducer(){
        return new KafkaProducer(producerProps());
    }

    private Map<String, Object> producerProps() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.97.136:9092");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
        //一次拉取消息数量
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "5");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }
}
