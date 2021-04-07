package com.xh.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/4/7 15:53
 * @description
 */
@Component
@Slf4j
public class MyComsumer {

    @KafkaListener(topics = "${spring.kafka.topic-name.mytpc}",groupId = "g1")
    public void handleNamedOrderMsg(String record) {
        log.info("**^** KafkaListener - handleNamedOrderMsg get order: {}", record);
    }

    @KafkaListener(id = "batch",clientIdPrefix = "batch",topics = {"topic.quick.batch"},containerFactory = "batchContainerFactory")
    public void batchListener(List<String> data) {
        log.info("topic.quick.batch  receive : ");
        for (String s : data) {
            log.info(  s);
        }
    }


    /**
     * @TopicPartition：topic--需要监听的Topic的名称，partitions --需要监听Topic的分区id，
     * partitionOffsets --可以设置从某个偏移量开始监听
     * @PartitionOffset：partition --分区Id，非数组，initialOffset --初始偏移量
     */
    @KafkaListener(id = "batchWithPartition",clientIdPrefix = "bwp",containerFactory = "batchContainerFactory",
            topicPartitions = {
                    @TopicPartition(topic = "topic.quick.batch.partition",partitions = {"1","3"}),
                    @TopicPartition(topic = "topic.quick.batch.partition",partitions = {"0","4"},
                            partitionOffsets = @PartitionOffset(partition = "2",initialOffset = "100"))
            }
    )
    public void batchListenerWithPartition(List<String> data) {
        log.info("topic.quick.batch.partition  receive : ");
        for (String s : data) {
            log.info(s);
        }
    }
}
