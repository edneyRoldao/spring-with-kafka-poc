package com.edntisolutions.kafkademo.publishers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class FirstTopicPublisher {

    private final String topicName;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public FirstTopicPublisher(@Value("${app.topic.first.name}") String topicName,
                               KafkaTemplate<String, String> kafkaTemplate) {
        this.topicName = topicName;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishMessage(String message) {
        kafkaTemplate.send(topicName, message);
    }

}
