package com.sparta.gatewayserver.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class RateLimiterConfig {

	@Bean
	public KeyResolver userKeyResolver() {
		return exchange -> {
			String clientIP = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();

			return Mono.just(clientIP);

			// 또는 인증된 사용자 ID 기반
			// return exchange.getPrincipal()
			//     .map(principal -> principal.getName())
			//     .defaultIfEmpty("anonymous");
		};
	}
}

