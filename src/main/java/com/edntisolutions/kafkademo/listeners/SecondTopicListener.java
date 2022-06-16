package com.edntisolutions.kafkademo.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SecondTopicListener {

    @KafkaListener(topics = "${app.topic.second.name}", groupId = "${app.topic.second.group}")
    public void listen(String message) {
        System.out.println("------------------");
        System.out.println("------------------");
        System.out.println("SECOND LISTENER TRIGGERED");
        System.out.println(message + " - " + UUID.randomUUID());
    }

}
