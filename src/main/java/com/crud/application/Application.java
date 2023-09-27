package com.crud.application;

import com.crud.application.service.KafkaReadyListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.crud.application.service.KafkaMessageProducerService;


@SpringBootApplication
public class Application {

	@Autowired
	KafkaReadyListener kafkaReadyListener;

	@Autowired
	private KafkaMessageProducerService kafkaMessageProducerService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void sendMessage() {
		try {
			kafkaReadyListener.getLatch().await();
			kafkaMessageProducerService.send("my-topic", "Testing Message");
			System.out.println("Not Broken");
		} catch (InterruptedException e) {
			System.out.println("Broken");
		}
	}
}
