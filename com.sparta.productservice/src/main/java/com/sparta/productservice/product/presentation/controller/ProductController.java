package com.sparta.productservice.product.presentation.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Value("${server.port}")
	private String serverPort;

	@GetMapping("{productId}/details")
	public String getProduct(@PathVariable("productId") Long productId) {
		return String.format("상품번호 %d, 서버포트: %s", productId, serverPort);
	}
}

