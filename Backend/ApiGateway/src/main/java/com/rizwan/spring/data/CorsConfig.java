package com.rizwan.spring.data;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
 
import reactor.core.publisher.Mono;
 
@Component
public class CorsConfig implements WebFilter {
 
	@Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        exchange.getResponse().getHeaders().add("Access-Control-Allow-Origin", "http://localhost:4200");
        exchange.getResponse().getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        exchange.getResponse().getHeaders().add("Access-Control-Allow-Headers", "Content-Type, Authorization");
        exchange.getResponse().getHeaders().add("Access-Control-Max-Age", "3600");
        if (exchange.getRequest().getMethod().equals(HttpMethod.OPTIONS)) {
            return Mono.empty();
        }
        return chain.filter(exchange);
    }
}
