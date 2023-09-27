package com.crud.application.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import java.util.concurrent.CountDownLatch;

@Component
public class KafkaReadyListener {

    private final CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(id = "kafkaReadyListener", topics = "${spring.kafka.app.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void listenForKafkaReadiness(String message) {
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
