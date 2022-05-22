package com.edntisolutions.kafkademo.api;

import com.edntisolutions.kafkademo.service.ProduceMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProducerController {

    private static int COUNTER = 1;

    private final ProduceMessageService service;

    @GetMapping("api/kafka-demo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sendMessageTest() {
        service.sendMessage("send message from rest API - " + COUNTER++, "kafka-demo-topic");
    }

}
