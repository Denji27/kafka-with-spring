package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.converter.JsonMessageConverter;

@Configuration
public class ConverterConfig {
    @Bean
    public JsonMessageConverter converter(){
        return new JsonMessageConverter();
    }
}
