package com.sparta.kafkaserver.kafka;

import java.time.LocalDateTime;

public record MessageTpl(
	String content,
	LocalDateTime createdAt
) {}
