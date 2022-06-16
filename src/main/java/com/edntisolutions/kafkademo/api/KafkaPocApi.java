package com.edntisolutions.kafkademo.api;

import com.edntisolutions.kafkademo.publishers.FirstTopicPublisher;
import com.edntisolutions.kafkademo.publishers.SecondTopicPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("kafka-poc/api")
public class KafkaPocApi {

    private final FirstTopicPublisher firstPublisher;
    private final SecondTopicPublisher secondPublisher;

    @PostMapping("send-message/first-topic")
    public ResponseEntity<String> postMessageFistTopic(@RequestParam("message") String message) {
        firstPublisher.publishMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).body("Message to the first topic has been sent");
    }

    @PostMapping("send-message/second-topic")
    public ResponseEntity<String> postMessageSecondTopic(@RequestParam("message") String message) {
        secondPublisher.publishMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).body("Message to the second topic has been sent");
    }

}

