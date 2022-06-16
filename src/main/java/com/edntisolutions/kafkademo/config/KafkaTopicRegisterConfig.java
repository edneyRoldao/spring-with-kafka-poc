package com.edntisolutions.kafkademo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * NOTE: when we use config class to create kafka topics, we need to run the application twice every topic registration
 *       first time: topic we be created
 *       second time and so on: the topic is available after topic creation
 * */

@Configuration
public class KafkaTopicRegisterConfig {

    @Value("${app.topic.first.name}")
    private String firstTopic;

    @Value("${app.topic.second.name}")
    private String secondTopic;

    @Bean
    public NewTopic firstTopic() {
        return TopicBuilder.name(firstTopic).build();
    }

    @Bean
    public NewTopic secondTopic() {
        return TopicBuilder.name(secondTopic).build();
    }

}
