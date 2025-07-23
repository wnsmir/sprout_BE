package com.example.sprout_BE.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        // 실제 HyperCLOVA X API의 기본 URL로 설정해야 합니다.
        // 예: .baseUrl("https://clovastudio.stream.ntruss.com")
        return builder.build();
    }
}