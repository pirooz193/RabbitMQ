package com.sohatask.rabbitmq.controller;


import com.sohatask.rabbitmq.consumer.Receiver;
import com.sohatask.rabbitmq.producer.Publisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class PublisherController {

    @GetMapping("/get-data")
    public void getData() {
        try {
            Publisher.publish();
            Receiver.receive(PublisherController.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
