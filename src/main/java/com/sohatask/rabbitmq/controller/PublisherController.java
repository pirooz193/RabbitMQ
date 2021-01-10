package com.sohatask.rabbitmq.controller;


import com.sohatask.rabbitmq.domain.Person;
import com.sohatask.rabbitmq.service.RabbitMQSender;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class PublisherController {


    private final RabbitMQSender rabbitMQSender;

    public PublisherController(RabbitMQSender rabbitMQSender) {
        this.rabbitMQSender = rabbitMQSender;
    }

    @PostMapping("/get-person")
    public String getPerson(@RequestBody Person person) {

        rabbitMQSender.send(person);
        return "successfully sent !";
    }

}
