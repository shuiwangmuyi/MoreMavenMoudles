package com.blockingqueuedome.KafkaTests;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @title: KafkaTestDome
 * @Author Wy
 * @Date: 2022/8/23 14:01
 * @Version 1.0
 */
public class KafkaTestDome {
    @Autowired
    private KafkaProducer kafkaProducer;
//    @Test
    public void testKafka() {
        kafkaProducer.sendMessage("test1", "你好");
        kafkaProducer.sendMessage("test1", "在吗");
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 生产者是主动发出消息
 */
@Component
class KafkaProducer{
    @Autowired
    private KafkaTemplate kafkaTemplate;
    public void sendMessage(String topic,String content){
        kafkaTemplate.send(topic,content);
    }
}


/**
 * 消费者是被动执行
 */
@Component
class KafkaConsumer{
    @KafkaListener(topics = {"test1"})
    public void handleMessage(ConsumerRecord record){
        System.out.println(record.value());
    }
}
