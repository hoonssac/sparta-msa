package com.sparta.kafkaserver.kafka;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

	// private static final Logger logger = LoggerFactory.getLogger(MessageListener.class);

	@KafkaListener(topics = "hub.order", containerFactory =
		"kafkaListenerContainerFactory")
	public void onMessage(MessageTpl message, @Header(KafkaHeaders.RECEIVED_KEY) String key) {
		System.out.printf("수신 받은 메시지: key: %s, value: %s%n", key, message);
	}
}
