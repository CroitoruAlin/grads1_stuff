package com.endava.springbootday3part5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Springbootday3part5Application {

    public static void main(String[] args) {
        SpringApplication.run(Springbootday3part5Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
