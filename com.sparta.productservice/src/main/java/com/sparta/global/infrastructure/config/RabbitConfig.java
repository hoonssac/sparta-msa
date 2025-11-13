package com.sparta.global.infrastructure.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
public class RabbitConfig {

	@Value("${rabbit.product.exchange}")
	private String exchange;

	@Value("${rabbit.product.queue}")
	private String queue;

	@Value("${rabbit.product.routing-key}")
	private String routingKey;

	@Bean
	public TopicExchange productExchange() {
		return new TopicExchange(exchange, true, false);
	}

	@Bean
	public Queue productQueue() {
		return QueueBuilder.durable(queue).build();
	}

	@Bean
	public Binding productBinding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(routingKey);
	}

	@Bean
	public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}

