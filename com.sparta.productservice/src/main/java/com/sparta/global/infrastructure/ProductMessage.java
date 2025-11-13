package com.sparta.global.infrastructure;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProductMessage {
	private Long id;
	private String content;
	private LocalDateTime createdAt;
}
