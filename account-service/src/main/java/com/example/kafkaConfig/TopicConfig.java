package com.example.kafkaConfig;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {
    @Bean
    public NewTopic notification(){
        return new NewTopic("notification", 2, (short) 1);
    }
    @Bean
    public NewTopic statistic(){
        return new NewTopic("statistic", 1, (short) 1);
    }

}
