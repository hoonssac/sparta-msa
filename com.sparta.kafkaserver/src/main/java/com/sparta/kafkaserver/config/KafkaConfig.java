package com.sparta.kafkaserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.sparta.kafkaserver.kafka.MessageTpl;

@Configuration
public class KafkaConfig {

	@Bean
	public KafkaTemplate<String, MessageTpl> kafkaTemplate
		(ProducerFactory<String, MessageTpl> producerFactory) {
		return new KafkaTemplate<>(producerFactory);
	}
}
