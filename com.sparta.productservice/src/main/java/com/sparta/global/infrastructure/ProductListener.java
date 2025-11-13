package com.sparta.global.infrastructure;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ProductListener {

	@RabbitListener(queues = "product.queue")
	public void onMessage(ProductMessage message) {
		log.info("수신:{}", message);
	}
}
