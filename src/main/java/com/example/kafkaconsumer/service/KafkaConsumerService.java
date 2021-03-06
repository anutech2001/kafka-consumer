package com.example.kafkaconsumer.service;

import com.example.kafkaprovider.model.Event;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "event", groupId = "myGroup")
    public void consumeEvent(Event event, ConsumerRecord<?, ?> record) {

        // logger.info(String.format("Consume event message: '%s'", event));
        logger.info(
                "Partition:" + record.partition() + ", Offset:" + record.offset() + ", Message|" + event.toString());
    }

}