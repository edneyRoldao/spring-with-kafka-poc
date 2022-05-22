package com.edntisolutions.kafkademo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumeMessageService {

    @KafkaListener(topics = "kafka-demo-topic", groupId = "groupId")
    public void listen(String message) {
        log.warn("#### KAFKA CONSUMER ####");
        log.warn("listener received the following message:{} ", message);
    }

}
