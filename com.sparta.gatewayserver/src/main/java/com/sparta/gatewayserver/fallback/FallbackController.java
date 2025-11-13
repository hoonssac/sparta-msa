package com.sparta.gatewayserver.fallback;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/fallback")
public class FallbackController {
	@GetMapping("/fallback/users")
	public Mono<ResponseEntity<Map<String, String>>> userServiceFallback() {
		Map<String, String> response = new HashMap<>();
		response.put("message", "사용자 서비스가 현재 응답하지 않습니다. 잠시 후 다시 시도해주세요.");

		return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response));
	}
}

