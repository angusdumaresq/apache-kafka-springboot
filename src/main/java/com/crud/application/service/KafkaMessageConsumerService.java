package com.crud.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(KafkaMessageConsumerService.class);

    @KafkaListener(topics = "${spring.kafka.app.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        logger.info("Message - ", message);

        try{

        } catch (Exception e) {
            logger.error("Error processing Kafka message: {}", e.getMessage(), e);
        }
    }
}
