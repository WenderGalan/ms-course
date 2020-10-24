package io.github.wendergalan.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    // Singleton
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
