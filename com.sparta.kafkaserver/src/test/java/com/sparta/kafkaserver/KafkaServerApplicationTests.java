package com.sparta.kafkaserver;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import com.sparta.kafkaserver.kafka.MessageTpl;

@SpringBootTest
class KafkaServerApplicationTests {

	@Autowired
	KafkaTemplate<String, MessageTpl> template;

	@Test
	void contextLoads() {
		template.send("hub.order", "testkey", new MessageTpl("테스트 메시지", LocalDateTime.now()));
	}

}
