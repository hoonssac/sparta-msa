package com.sparta.productservice.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@SpringBootTest
public class LoadBalancingTest {
	@Autowired
	RestTemplate restTemplate;

	@Test
	void test() {
		String body = restTemplate.getForObject(URI.create("http://product-service/111/details"), String.class);
		System.out.println(body);
	}
}
